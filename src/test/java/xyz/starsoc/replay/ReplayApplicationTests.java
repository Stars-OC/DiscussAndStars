package xyz.starsoc.replay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import xyz.starsoc.replay.mapper.ReplyMapper;
import xyz.starsoc.replay.mapper.ReplyStarMapper;
import xyz.starsoc.replay.pojo.ReplyStar;
import xyz.starsoc.replay.service.ReplyService;

import java.util.concurrent.atomic.AtomicBoolean;

@SpringBootTest
@EnableTransactionManagement
class ReplayApplicationTests {

    @Autowired
    private ReplyMapper replayMapper;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyStarMapper replyStarMapper;

    @Test
    void contextLoads() {
        AtomicBoolean atomicBoolean = replyService.updateStar(13L, 14L, true);
        System.out.println(atomicBoolean.get());
        System.out.println(1);
//        ReplayStar star = ReplayStar.builder().username(1L).contentId(1L).build();
////        replayStarMapper.insertByEntity(star);
//        int i = replayStarMapper.deleteById(star);
    }

    @Transactional
    void test(){
        System.out.println(2);
        ReplyStar star = ReplyStar.builder().username(1124L).contentId(1L).build();
        replyStarMapper.insert(star);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        System.out.println(1);
    }

}
