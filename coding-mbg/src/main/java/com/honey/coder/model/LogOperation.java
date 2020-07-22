package com.honey.coder.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class LogOperation implements Serializable {
    private Long id;

    @ApiModelProperty(value = "用户账号")
    private String opUserAccount;

    @ApiModelProperty(value = "用户名称")
    private String opUserName;

    @ApiModelProperty(value = "操作大类,技能管理")
    private String opCategory;

    @ApiModelProperty(value = "操作子类,技能开发")
    private String opSubCategory;

    @ApiModelProperty(value = "操作类型,0:新增 1:修改 2:删除")
    private Integer opType;

    @ApiModelProperty(value = "描述")
    private String opDesc;

    @ApiModelProperty(value = "操作结果")
    private String opResult;

    @ApiModelProperty(value = "调用的后台方法")
    private String opMethod;

    @ApiModelProperty(value = "操作耗时")
    private Long opCost;

    @ApiModelProperty(value = "请求路径")
    private String opUri;

    @ApiModelProperty(value = "请求ip")
    private String opIp;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "操作参数")
    private String opParam;

    @ApiModelProperty(value = "请求扩展字段")
    private String opExtend;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpUserAccount() {
        return opUserAccount;
    }

    public void setOpUserAccount(String opUserAccount) {
        this.opUserAccount = opUserAccount;
    }

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }

    public String getOpCategory() {
        return opCategory;
    }

    public void setOpCategory(String opCategory) {
        this.opCategory = opCategory;
    }

    public String getOpSubCategory() {
        return opSubCategory;
    }

    public void setOpSubCategory(String opSubCategory) {
        this.opSubCategory = opSubCategory;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public String getOpDesc() {
        return opDesc;
    }

    public void setOpDesc(String opDesc) {
        this.opDesc = opDesc;
    }

    public String getOpResult() {
        return opResult;
    }

    public void setOpResult(String opResult) {
        this.opResult = opResult;
    }

    public String getOpMethod() {
        return opMethod;
    }

    public void setOpMethod(String opMethod) {
        this.opMethod = opMethod;
    }

    public Long getOpCost() {
        return opCost;
    }

    public void setOpCost(Long opCost) {
        this.opCost = opCost;
    }

    public String getOpUri() {
        return opUri;
    }

    public void setOpUri(String opUri) {
        this.opUri = opUri;
    }

    public String getOpIp() {
        return opIp;
    }

    public void setOpIp(String opIp) {
        this.opIp = opIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpParam() {
        return opParam;
    }

    public void setOpParam(String opParam) {
        this.opParam = opParam;
    }

    public String getOpExtend() {
        return opExtend;
    }

    public void setOpExtend(String opExtend) {
        this.opExtend = opExtend;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", opUserAccount=").append(opUserAccount);
        sb.append(", opUserName=").append(opUserName);
        sb.append(", opCategory=").append(opCategory);
        sb.append(", opSubCategory=").append(opSubCategory);
        sb.append(", opType=").append(opType);
        sb.append(", opDesc=").append(opDesc);
        sb.append(", opResult=").append(opResult);
        sb.append(", opMethod=").append(opMethod);
        sb.append(", opCost=").append(opCost);
        sb.append(", opUri=").append(opUri);
        sb.append(", opIp=").append(opIp);
        sb.append(", createTime=").append(createTime);
        sb.append(", opParam=").append(opParam);
        sb.append(", opExtend=").append(opExtend);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}