package com.mit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mit.dto.Feed;
import com.mit.dto.User;
import com.mit.repo.FeedRepo;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	private FeedRepo feedRepo;

	@Override
	public List<Feed> selectAll() {
		// TODO Auto-generated method stub
		return feedRepo.selectAll();
	}

	@Override
	public List<Feed> selectEmail(String email) {
		// TODO Auto-generated method stub
		return feedRepo.selectEmail(email);
	}

	@Override
	public Feed selectOne(String no) {
		// TODO Auto-generated method stub
		return feedRepo.selectOne(no);
	}

	@Override
	public boolean insert(Feed feed) {
		// TODO Auto-generated method stub
		return feedRepo.insert(feed);
	}

	@Override
	public boolean update(Feed feed) {
		// TODO Auto-generated method stub
		return feedRepo.update(feed);
	}

	@Override
	public boolean delete(String no) {
		// TODO Auto-generated method stub
		return feedRepo.delete(no);
	}

	@Override
	public String Latestfeed(String email) {
		// TODO Auto-generated method stub
		return feedRepo.Latestfeed(email);
	}

	@Override
	public User selectPrivate(String email) {
		// TODO Auto-generated method stub
		return feedRepo.selectPrivate(email);
	}

}