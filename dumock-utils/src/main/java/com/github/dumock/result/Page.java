package com.github.dumock.result;

import lombok.*;

/**
 * 分页对应的实体类
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Page {
    /**
     * 总条数
     *
    */
    @NonNull
    private int totalNumber;
    /**
     * 当前第几页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示条数
     */
    private int pageNumber = 10;
    /**
     * 数据库中limit的参数，从第几条开始取
     */
    private int dbIndex;
    /**
     * 数据库中limit的参数，一共取多少条
     */
    private int dbNumber;

    /**
     * 根据当前对象中属性值计算并设置相关属性值
     */
    public void count() {
        // 计算总页数
        int totalPageTemp = this.totalNumber / this.pageNumber;
        int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if(totalPageTemp <= 0) {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;

        // 设置当前页数
        // 总页数小于当前页数，应将当前页数设置为总页数
        if(this.totalPage < this.currentPage) {
            this.currentPage = this.totalPage;
        }
        // 当前页数小于1设置为1
        if(this.currentPage < 1) {
            this.currentPage = 1;
        }

        // 设置limit的参数
        this.dbIndex = (this.currentPage - 1) * this.pageNumber;
        this.dbNumber = this.pageNumber;
    }


}

