package com.example.spring06.model.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.spring06.model.memo.dto.MemoDTO;

public interface MemoDAO {
	
	@Select("select * from memo order by idx desc")
	public List<MemoDTO> list();
	
	//만약 데이터가 하나도 안들어가있다면 memo의 max(dix)값은 null이다. 
	// nvl(a,b) 만약 a가 null일 경우 b반환 null이 아닐경우 a반환
	
	
	@Insert("insert into memo (idx,writer,memo) "
	+"values ((select nvl(max(idx)+1,1) from memo),#{writer},#{memo})")
	public void insert(@Param("writer") String writer, 
			@Param("memo") String memo);
	//함수에서 읽어온 writer,memo String을 id가 writer,memo인 파라미터로  저장 -> 디비에서 사용#
	//mybatis에서 사용방법
	@Select("select * from memo where idx=#{idx}")
	public MemoDTO memo_view(@Param("idx")int idx);
	
	@Update("update memo set writer=#{writer}, memo=#{memo} "
			+ "where idx=#{idx}")
	public void memo_update(MemoDTO dto);
	
	@Delete("delete memo where idx=#{idx}")
	public void memo_delete(@Param("idx") int idx);
}
