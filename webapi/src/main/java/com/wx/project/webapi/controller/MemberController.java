package com.wx.project.webapi.controller;

import com.wx.project.model.Member;
import com.wx.project.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luyh on 16/4/27.
 */

@RestController
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @RequestMapping("/member/{memberId}")
    Member findMemberByMemberId(@PathVariable("memberId") Integer memberId) throws Exception{
       return memberService.findMemberByMemberId(memberId);
    }



}
