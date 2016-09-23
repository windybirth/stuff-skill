package jp.wicresoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.wicresoft.impl.SkillMasterImpl;

@Controller
public class SkillMasterController {

	@Autowired
	SkillMasterImpl skillMasterImpl;
}
