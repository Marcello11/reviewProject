package com.marcello.service.impl;

import com.marcello.dao.PostingDao;
import com.marcello.entity.Posting;
import com.marcello.entity.Reply;
import com.marcello.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/10$ 19:26$
 **/
@Service
public class PostingServiceImpl implements PostingService {
    @Autowired
    private PostingDao postingDao;
    @Override
    public void addPosting(Posting posting){
       postingDao.addPosting(posting);}

    @Override
    public void publishPosting(Posting posting){postingDao.publishPost(posting);}

    @Override
    public void deletePosting(int id){postingDao.deletePosting(id);}

    @Override
    public List<Posting> postOccasion(Posting posting){return postingDao.postOccasion(posting);}

    @Override
    public Posting findPostById(int id){return postingDao.findById(id);}

    @Override
    public Posting findPostByTitle(Posting posting){
        return postingDao.findPostByTitle(posting);
    }

    @Override
    public List<Posting> getPostList(Map<String,Object> map){return postingDao.getPostList(map);}

    @Override
    public void addReply(Reply reply){ postingDao.addReply(reply);}

    @Override
    public List<Reply> getReply(int msgid){return postingDao.findReply(msgid); }

    @Override
    public List<Posting> myPosting(String bssName){return postingDao.findPostByUser(bssName);}
}
