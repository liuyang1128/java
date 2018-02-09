/**
 * 2018年1月30日
 * Yang.Liu
 */
package com.yang.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yang.core.InvokeResult;
import com.yang.dao.UserInfoDTO;
import com.yang.service.UserService;

/**
 * 用户登录服务控制类
 * 
 * Package : com.yang.controller
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月30日 下午5:05:36
 *
 */
@RestController
@RequestMapping("/user")
public class UserLoginController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private UserService userService;

    /**
     * 登录验证
     * 
     * @return 结果
     * @author YixinCapital -- Yang.Liu
     *	       2018年1月27日 下午5:37:06
     */
    @ResponseBody
    @RequestMapping("/login")
    public InvokeResult<Boolean> login(UserInfoDTO dto) {
    	InvokeResult<Boolean> result = new InvokeResult<>();
		try {
			result.setData(userService.login(dto));
			result.setHasErrors(false);
        }catch (Exception e) {
        	logger.error("登录异常");
        	result.setHasErrors(false);
        	result.setErrorMessage("登录异常");
        }
        return result;
    }

}

