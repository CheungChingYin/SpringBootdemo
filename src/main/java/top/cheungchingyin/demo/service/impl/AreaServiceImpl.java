package top.cheungchingyin.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cheungchingyin.demo.dao.AreaDao;
import top.cheungchingyin.demo.entity.Area;
import top.cheungchingyin.demo.service.AreaService;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();//直接返回查询结果
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);//直接返回单个id的查询结果
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){//检查传入值不能为空值
            area.setCreateTime(new Date());//设置创建时间
            area.setLastEditTime(new Date());//设置修改时间
            try {
                int effectedNum = areaDao.insertArea(area);//如果执行成功返回1，不成功则返回0
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败");//执行不成功抛出异常
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败："+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && !"".equals(area.getAreaName())){
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("修改区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("修改区域信息失败："+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId >0){
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败："+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域ID不能为空!");
        }
    }
}
