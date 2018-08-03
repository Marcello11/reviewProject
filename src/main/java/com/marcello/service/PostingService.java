package com.marcello.service;

import com.marcello.entity.Posting;
import com.marcello.entity.Reply;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/10$ 17:39$
 **/
public interface PostingService {
    /**
     * 发布帖子
     * @param posting
     */
     void addPosting(Posting posting);

    /**
     * 删除帖子
     * @param id
     */
     void deletePosting(int id);

    /**
     * 发布待审核帖子
     * @param posting
     */
     void publishPosting(Posting posting);

    /**
     * 根据id查找帖子
     * @param id
     * @return
     */
     Posting findPostById(int id);

    /**
     * 获取帖子列表
     * @param map
     * @return
     */
     List<Posting> getPostList(Map<String, Object> map);

    /**
     * 待审核的帖子列表
     * @param posting
     * @return
     */
     List<Posting> postOccasion(Posting posting);

    /**
     * 根据标题查找
     * @param posting
     * @return
     */
    Posting findPostByTitle(Posting posting);

    /**
     * 发表回复
     * @param reply
     * @return
     */
    void addReply(Reply reply);

    /**
     * 得到回复
     * @param msgid
     * @return
     */
    List<Reply> getReply(int msgid);

    /**
     * 查询当前用户发布的帖子
     * @param bssName
     * @return
     */
    List<Posting> myPosting(String bssName);
}
