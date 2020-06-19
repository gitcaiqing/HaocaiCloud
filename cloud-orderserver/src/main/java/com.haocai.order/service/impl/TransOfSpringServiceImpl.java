package com.haocai.order.service.impl;

import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.order.service.TransOfSpringService;
import com.haocai.order.service.TransOrderService;
import org.dromara.hmily.annotation.PropagationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/19 13:08
 **/
@Service
public class TransOfSpringServiceImpl implements TransOfSpringService {

    @Autowired
    private TransOrderService transOrderService;

    /**
     * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/19 13:15
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testPropagationRequired() {
        Date now = new Date();

        //testPropagationRequired 方法上未加 @Transactional(propagation = Propagation.REQUIRED)

        //正常插入
        //transOrderService.addRequired1(now);
        //正常插入
        //transOrderService.addRequired2(now);
        //此处异常以上事务正常提交，说明：外围方法未开启事务，addRequired1和addRequired2在自己独立的事务中运行，外围方法异常
        //不影响内部事务的运行提交
        //throw new RuntimeException();
        //正常插入
        //transOrderService.addRequired1(now);
        //此事务回滚
        //transOrderService.addRequired2Exception(now);

        //testPropagationRequired 方法上加 @Transactional(propagation = Propagation.REQUIRED)

        //此事务回滚
        transOrderService.addRequired1(now);
        //此事务回滚
        //外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，即使方法被catch不被外围方法感知，整个事务依然回滚。
        try {
            transOrderService.addRequired2Exception(now);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //此事务回滚
        //transOrderService.addRequired1(now);
        //此事务回滚
        //transOrderService.addRequired2(now);
        //此处异常以上事务正常回滚，说明：外围方法开启事务，内部方法加入外围方法事务，外围方法回滚，内部方法也要回滚。
        //throw new RuntimeException();
    }

    /**
     * 支持当前事务，如果当前没有事务，就以非事务方式执行。
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/19 15:35
     */
    @Override
    //@Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.SUPPORTS)
    public void testPropagationSupports() {
        Date now = new Date();

        //testPropagationSupports 方法上未加 @Transactional(propagation = Propagation.REQUIRED)

        //外部方法没有添加事务 addSupports1 和 addSupports2Exception
        // 即使添加事务注解 @Transactional(propagation = Propagation.SUPPORTS) 也是非事务的，所以addSupports2Exception不会回滚
        //transOrderService.addSupports1(now);
        //transOrderService.addSupports2Exception(now);

        //testPropagationSupports 方法上加 @Transactional(propagation = Propagation.REQUIRED)

        //外部方法添加了事务， addSupports1 和 addSupports2Exception也带上了事务 类似 REQUIRED
        //addSupports2Exception 异常整体回滚
        //transOrderService.addSupports1(now);
        //transOrderService.addSupports2Exception(now);

        //外部方法添加了事务， addSupports1 和 addSupports2Exception也带上了事务 类似 REQUIRED
        //addSupports2Exception 异常被catch 仍可被外部方法感知 进行整体回滚
        /*transOrderService.addSupports1(now);
        try {
            transOrderService.addSupports2Exception(now);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //testPropagationSupports 方法上加 @Transactional(propagation = Propagation.SUPPORTS)
        //此方法未非事务，抛runtime异常不回滚，会正常插入
        transOrderService.addNoSupports1(now);
        throw new RuntimeException();
    }

    /**
     * 使用当前的事务，如果当前没有事务，就抛出异常。
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/19 16:11
     */
    @Override
    public void testPropagationMandatory() {
        Date now = new Date();

        //testPropagationMandatory 方法上未加 @Transactional事务注解
        //会抛异常 No existing transaction found for transaction marked with propagation 'mandatory'
        transOrderService.addMandatory1(now);

    }

    /**
     * 新建事务，如果当前存在事务，把当前事务挂起。
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/19 14:41
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testPropagationRequireNew() {
        Date now = new Date();

        //testPropagationRequireNew 方法上未加 @Transactional(propagation = Propagation.REQUIRED)
        //正常插入
        //transOrderService.addRequiredNew1(now);
        //正常插入
        //transOrderService.addRequiredNew2(now);
        //此处异常以上事务正常提交，说明：外围方法未开启事务，addRequiredNew1 addRequiredNew2 在自己独立的事务中运行，外围方法异常
        //不影响内部事务的运行提交
        //throw new RuntimeException();


        //testPropagationRequireNew 方法上未加 @Transactional(propagation = Propagation.REQUIRED)

        //正常插入
        //transOrderService.addRequiredNew1(now);
        //此事务回滚
        //transOrderService.addRequiredNew2Exception(now);

        //此事务回滚
        //transOrderService.addRequired1(now);
        //正常插入 此方法开启了独立的新事务
        //transOrderService.addRequiredNew1(now);
        //throw new RuntimeException();

        //正常插入
        transOrderService.addRequired1(now);
        //正常插入
        transOrderService.addRequiredNew2(now);
        //此处异常以上事务正常回滚，说明：外围方法开启事务，内部方法为独立的事务，异常被catch 不被外部感知，所以 addRequired1 不会回滚
        try {
            transOrderService.addRequiredNew2Exception(now);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/19 16:21
     */
    @Override
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.REQUIRED)
    public void testPropagationNotSupported() {

        Date now = new Date();

        // testPropagationNotSupported 加上 @Transactional(propagation = Propagation.NOT_SUPPORTED)

        //transOrderService.addRequired1(now);
        //抛出异常 但是仍然插入，因为事务被挂起
        //throw new BusinessException("NOT_SUPPORTED exception");

        // testPropagationNotSupported 加上 @Transactional(propagation = Propagation.REQUIRED)

        //方法 addNotSupportedException1 添加了注解@Transactional(propagation = Propagation.NOT_SUPPORTED)
        //外部方法上开启的事务被挂起，addNotSupportedException1 正常插入，不回滚
        transOrderService.addNotSupportedException1(now);

    }

    /**
     * 以非事务方式执行，如果当前存在事务，则抛出异常。
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/19 16:17
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testPropagationNever() {

        //会抛出异常 Existing transaction found for transaction marked with propagation 'never'
        transOrderService.addNever1(new Date());
    }

    /**
     * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     * 试验结果 外围方法开启事务的情况下Propagation.NESTED修饰的内部方法属于外部事务的子事务，外围主事务回滚，子事务一定回滚，
     * 而内部子事务可以单独回滚而不影响外围主事务和其他子事务
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/19 14:41
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testPropagationNested() {
        Date now = new Date();

        //testPropagationNested 方法上未加 @Transactional(propagation = Propagation.NESTED)

        //正常插入
        //transOrderService.addNested1(now);
        //正常插入
        //transOrderService.addNested2(now);
        //此处异常以上事务正常提交，说明：外围方法未开启事务，addNested1 addNested2 在自己独立的事务中运行，外围方法异常
        //不影响内部事务的运行提交
        //throw new RuntimeException();

        //正常插入
        //transOrderService.addNested1(now);
        //外围方法没有事务 此方法再独立的事务中运行 抛出异常会回滚插入
        //addNested2Exception(now);

        //testPropagationNested 方法上加 @Transactional(propagation = Propagation.REQUIRED)
        //回滚
        //transOrderService.addNested1(now);
        //回滚
        //transOrderService.addNested2(now);
        //外围方法开启事务，内部事务为外围事务的子事务，外围方法回滚，内部方法也要回滚。
        //throw new RuntimeException();

        //回滚
        //transOrderService.addNested1(now);
        //回滚
        //外围方法开启事务，内部事务为外围事务的子事务，内部方法抛出异常回滚，且外围方法感知异常致使整体事务回滚。
        //transOrderService.addNested2Exception(now);

        //插入
        transOrderService.addNested1(now);
        transOrderService.addNested2(now);
        //回滚
        //外围方法开启事务，内部事务为外围事务的子事务，内部方法抛出异常回滚，进行catch 外围方法不感知 单独对子事务回滚， 外部事务部回滚。
        try {
            transOrderService.addNested2Exception(now);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
