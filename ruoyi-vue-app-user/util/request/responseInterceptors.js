/**
 * 响应拦截
 * @param {Object} http
 */
module.exports = (vm) => {
    uni.$u.http.interceptors.response.use((response) => { /* 对响应成功做点什么 可使用async await 做异步操作*/
        const data = response.data
        // 自定义参数
        const custom = response.config?.custom
        if (data.code == 200 || data.code == 201) {
            return data || {};
        } else if (data.code == 401) {
            // uni.$u.toast('请先登录后再操作哦');
            // return data || {};
            uni.$u.route({url: 'pages/login/default-login'});
            return {};
        } else {
            uni.$u.toast(data.msg);
            return new Promise(() => { });
            // 如果需要catch返回，则进行reject
            // if (custom?.catch) {
            // return Promise.reject(data)
            // }
        }
        return data || {}
        return data || {}
    }, (response) => { /*  对响应错误做点什么 （statusCode !== 200）*/
        return Promise.reject(response)
    })
}
