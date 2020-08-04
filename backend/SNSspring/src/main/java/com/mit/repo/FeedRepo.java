package com.mit.repo;

import java.util.List;


import com.mit.dto.Feed;
import com.mit.dto.User;
public interface FeedRepo {
	public List<Feed> selectAll();
	public List<Feed> selectEmail(String email);
	public Feed selectOne(String no);
	public boolean insert(Feed feed);
	public boolean update(Feed feed);
	public boolean delete(String no);
	public String Latestfeed(String email);
	public User selectPrivate(String email);
}