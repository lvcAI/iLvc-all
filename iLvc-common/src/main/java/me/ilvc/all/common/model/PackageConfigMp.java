package me.ilvc.all.common.model;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.PackageConfig;

/**
 * @author Lvc
 * @create 2019/11/12 09:18
 */
public class PackageConfigMp extends PackageConfig {

    @Override
    public String getModuleName() {
        return super.getModuleName();
    }

    @Override
    public PackageConfig setParent(String parent) {
        return super.setParent(parent);
    }

    @Override
    public String getParent() {
        System.out.println(super.getParent());
        String parent = super.getParent().replace(StringPool.DOT + getModuleName(), "");
        System.out.println(parent);
        return parent;
    }
}
