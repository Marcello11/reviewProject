package com.marcello.dao;

import com.marcello.entity.Posting;
import com.marcello.entity.Reply;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/10$ 17:31$
 **/
public interface PostingDao {
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
     * 发布待审核的帖子
     * @param posting
     */
    void publishPost(Posting posting);

    /**
     * 根据id查找帖子
     * @param id
     * @return
     */
    Posting findById(int id);

    /**
     * 全部帖子列表
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
     * 发表回复
     * @param reply
     * @return
     */
    void addReply(Reply reply);

    /**
     * 根据标题查找
     * @param posting
     * @return
     */
    Posting findPostByTitle(Posting posting);

    /**
     * 利用多表联合查询查询回复
     * @param msgid
     * @return
     */
    List<Reply> findReply(int msgid);

    /**
     * 根据用户名查找帖子
     * @param bssName
     * @return
     */
    List<Posting> findPostByUser(String bssName);
}
