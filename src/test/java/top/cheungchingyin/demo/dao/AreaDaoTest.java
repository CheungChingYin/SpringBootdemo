package top.cheungchingyin.demo.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cheungchingyin.demo.entity.Area;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("1苑");
        area.setPriority(1);
        int result = areaDao.insertArea(area);
        assertEquals(1,result);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setAreaId(6);
        area.setLastEditTime(new Date());
        int result = areaDao.updateArea(area);
        assertEquals(1,result);
    }

    @Test
    @Ignore
    public void deleteArea() {
        int result = areaDao.deleteArea(6);
    }
}