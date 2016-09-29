package jp.wicresoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.wicresoft.impl.SkillMasterEditImpl;

@Controller
public class SkillMasterEditController {

	@Autowired
	SkillMasterEditImpl skillMasterEditImpl;
}
