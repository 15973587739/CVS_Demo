package cn.cvs.service.impl;

import cn.cvs.dao.tAddress.TAddressMapper;
import cn.cvs.dao.tsysUser.TSysUserMapper;
import cn.cvs.service.TAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:30
 **/
public class TAddressServiceImpl implements TAddressService {
    private TAddressMapper addressMapper;
}
