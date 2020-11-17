package com.cg.oiqgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.oiqgs.model.BusinessSegment;

public class BusinessRepoImpl {
	PreparedStatement psmt;
	ResultSet bResultSet;
	Connection connection;

	public BusinessRepoImpl() throws SQLException {
		connection=DBUtil.createConnection();
	}
	
	public BusinessSegment addBusinessSegment(BusinessSegment businessSegment ) throws SQLException {
		
		psmt=connection.prepareStatement("insert into Business_Segment values(?,?,?)");
		psmt.setString(1, businessSegment.getBusSegId());
		psmt.setString(2, businessSegment.getBusSegName());
		psmt.setInt(3, businessSegment.getBusSegSeq());
				
		int count=psmt.executeUpdate();
		return businessSegment;
		
	}
	public List<BusinessSegment> getAllBusinessSegment() throws SQLException {
		
		psmt=connection.prepareStatement("select * from Business_Segment");
			
			bResultSet=psmt.executeQuery();
			
			List<BusinessSegment> s=new ArrayList<BusinessSegment>();
			while(bResultSet.next()) {
			BusinessSegment businessSegment=new BusinessSegment();
			businessSegment.setBusSegId(bResultSet.getString("busSeqId"));
			businessSegment.setBusSegName(bResultSet.getString("busSeqName"));
			businessSegment.setBusSegSeq(bResultSet.getInt("busSeqSeq"));
			s.add(businessSegment);
		}
			return s;
		}
	
}
