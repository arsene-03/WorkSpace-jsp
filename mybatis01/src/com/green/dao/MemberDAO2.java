package com.green.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.green.vo.MemberVO;

public class MemberDAO2 {  //마이바티스 적용 코드
	private MemberDAO2() {}
	private static MemberDAO2 dao2 = new MemberDAO2();
	public static MemberDAO2 getInstance() {
		return dao2;
	}
	
	public static SqlSessionFactory sqlMapper = null;
	
	private static SqlSessionFactory getFactory() {
		if(sqlMapper==null) {
			try {
				String resource = "mybatis/SqlConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		
		// MemberVO객체의 필드로서 id,name,email등이 저장  => 레코드 단위로 데이터 추출
		
		sqlMapper = getFactory();
		SqlSession session = sqlMapper.openSession();
		list = session.selectList("mybatis.mapper.member.selectAll");
		return list;
	}
	public List<HashMap<String,String>> selectAllToHash(){
		List<HashMap<String,String>> lists = null;
		int cnt = 0;
		// 해시맵으로 키:id,name,email~~  값으로 데이터를 저장  => 특징 데이터를 레코드 구분 하지 않는다.

		sqlMapper = getFactory();
		SqlSession session = sqlMapper.openSession();
		lists = session.selectList("mybatis.mapper.member.selectAllToHash");
		
		////////
		for(HashMap<String,String> members:lists) {
			Set<String> keys= members.keySet();
			
			Iterator<String> keyItr = keys.iterator();
			
			while(keyItr.hasNext()) {
				String key = keyItr.next();
				String value = String.valueOf(members.get(key));
				
				System.out.println((cnt++)+"번째 키 : "+key+" 그리고 밸류 : "+value);
			}
		}
		return lists;
	}
	
	public int selectCnt() {
		int cnt = 0;
		
		sqlMapper = getFactory();
		SqlSession session =sqlMapper.openSession();
		cnt = session.selectOne("mybatis.mapper.member.selectCNT");
		return cnt;
	}
	
	public MemberVO selectByEmail(String email) {
		MemberVO mVo = null;
		
		sqlMapper = getFactory();
		SqlSession session =sqlMapper.openSession();
		mVo = session.selectOne("mybatis.mapper.member.selectByEmail",email);
		return mVo;
		
	}
	
	

}
