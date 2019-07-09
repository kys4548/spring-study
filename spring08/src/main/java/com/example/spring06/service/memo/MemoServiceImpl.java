package com.example.spring06.service.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring06.model.memo.dao.MemoDAO;
import com.example.spring06.model.memo.dto.MemoDTO;

@Service
public class MemoServiceImpl implements MemoService {

	@Inject
	MemoDAO memoDao;
	@Override
	public List<MemoDTO> list() {
		// TODO Auto-generated method stub
		
		return memoDao.list();
	}

	@Override
	public void insert(MemoDTO dto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insert(String writer, String memo) {
		// TODO Auto-generated method stub
		memoDao.insert(writer,memo);
	}

	@Override
	public MemoDTO memo_view(int idx) {
		// TODO Auto-generated method stub
		return memoDao.memo_view(idx);
	}

	@Override
	public void update(MemoDTO dto) {
		// TODO Auto-generated method stub
		memoDao.memo_update(dto);
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		memoDao.memo_delete(idx);
	}

}
