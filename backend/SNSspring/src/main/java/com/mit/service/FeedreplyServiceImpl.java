package com.mit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mit.dto.Reply;
import com.mit.repo.FeedreplyRepo;

@Service
public class FeedreplyServiceImpl implements FeedreplyService {

	@Autowired
	private FeedreplyRepo feedreplyRepo;

	@Override
	public List<Reply> selectAll(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Reply reply) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reply reply) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reply reply) {
		// TODO Auto-generated method stub
		return false;
	}


}
