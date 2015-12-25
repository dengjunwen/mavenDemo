package com.cgq.util;

/**
 * @author zhangbin1 返回值 code码
 */
public class ResultCode {

	/**
	 * 0 .针对返回值success
	 */
	public static final Integer RESULT_CODE_SUCCESS = 0;
	/**
	 * success .针对msg success
	 */
	public static final String RESULT_CODE_SUCCESS_MSG = "请求成功";

	/**
	 * -1 .针对返回error
	 */
	public static final Integer RESULT_CODE_ERROR = -1;
	/**
	 * error.针对返回值 error
	 */
	public static final String RESULT_CODE_ERROR_MSG = "服务器异常";

	/**
	 * parameter.针对返回值 error
	 */
	public static final String RESULT_PARAMETER_ERROR_MSG = "请求参数不合法";
	/**
	 * parameter.针对返回值 error
	 */
	public static final String RESULT_TASK_INCOMPELETE_MSG = "当前 页任务没有完成";

	/**
	 * parameter.针对返回值 error
	 */
	public static final String RESULT_VERIFYCODE_ERROR_MSG = "验证码错误";

	public static final String RESULT_OUTOFMEETINGROOM_ERROR_MSG = "没有空闲的直播室";

	public static final Object RESULT_NOLIVECOURSE_ERROR_MSG = "直播课程已结束";
	
	public static final Object RESULT_NOCOURSE_ERROR_MSG = "没有课程";

	public static final String RESULT_CODE_ERROR_PASSWORD_MSG = "用户密码错误";
	
	public static final String RESULT_CODE_ERROR_MOBILE_NOT_EXIST_MSG = "账户不存在";
	
	public static final String RESULT_CODE_ERROR_MOBILE_EXIST_MSG = "账户已经存在";
	
	/**
	 * 无任务
	 */
	public static final Integer TASK_TYPE_NO_TASK = 0;

	/**
	 * 上传资源类型
	 */
	public static final Integer TASK_TYPE_UPLOAD_RESOURCE = 1;

	/**
	 * 回答问题类型 选择题
	 */
	public static final Integer TASK_TYPE_ANSWER_QUESTION = 2;

	/**
	 * 回答问题类型 文本类型
	 */
	public static final Integer TASK_TYPE_ANSWER_CONTENT = 3;
	/**
	 * 回答问题类型 提交心的评价
	 */
	public static final Integer TASK_TYPE_ANSWER_HEART = 4;

	/**
	 * 资源类型 0：音频
	 */
	public static final Integer RESOURCE_TYPE_VOICE = 0;
	/**
	 * 资源类型 1：视频
	 */
	public static final Integer RESOURCE_TYPE_VIDEO = 1;
	/**
	 * 资源类型 2：图片
	 */
	public static final Integer RESOURCE_TYPE_IMG = 2;

	/**
	 * 任务类型 task_type 0：online
	 */
	public static final Integer TASK_TYPE_ONLINE = 0;

	/**
	 * 任务类型 task_type 1：offline
	 */
	public static final Integer TASK_TYPE_OFFLINE = 1;

	/**
	 * 任务类型 task_type 2：live
	 */
	public static final Integer TASK_TYPE_LIVE = 2;

	
	/**
	 * 完成任务状态 status 0: 未完成
	 */
	public static final Integer STATUS_NOT_FINISHED = 0;

	/**
	 * 完成任务状态 status 1: 完成
	 */
	public static final Integer STATUS_FINISHED = 1;
	/**
	 * 学生的用户类型
	 */
	public static final Integer USER_TYPE_STUDENT = 0;
	/**
	 * 老师的用户类型
	 */
	public static final Integer USER_TYPE_TEACHER = 1;
	
	/**
	 * 外教
	 */
	public static final Integer USER_TYPE_FOREIGN_TEACHER = 2;
	
	/**
	 * 有效的数据记录
	 */
	public static final Integer ISEFFECTIVE=1;
	
	/**
	 * 学生作业上传 资源的来源码
	 */
	public static final Integer SOURCE_USERUPLOAD = 2;
	
	
	/**
	 * 用户头像来源码
	 */
	public static final Integer SOURCE_USERPIC = 1;
	
	/**
	 * 教师课件上传 资源的来源码
	 */
	public static final Integer SOURCE_TEACHER_COURSE_UPLOAD = 0;
	
	/**
	 * pageTask status == 0
	 * 页面任务是否需要完成  0 = 不需要
	 * 
	 */
	public static final Integer  PAGE_TASK_NEED_NOT  = 0;
	
	/**
	 * pageTask status == 1
	 * 页面任务是否需要完成  1 = 需要
	 * 
	 */
	public static final Integer  PAGE_TASK_NEEDED  = 1;
}
