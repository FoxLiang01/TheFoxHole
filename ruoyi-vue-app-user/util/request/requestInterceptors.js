import $config from '@/common/config.js';
import {validator} from '@/common/validator.js';

/**
 * 请求拦截
 * @param {Object} http
 */
module.exports = (vm) => {
    uni.$u.http.interceptors.request.use((config) => { // 可使用async await 做异步操作
        // 初始化请求拦截器时，会执行此方法，此时data为undefined，赋予默认{}
        config.data = config.data || {}
        // 可以在此通过vm引用vuex中的变量，具体值在vm.$store.state中
        // console.log(vm.$store.state);
        let token = uni.getStorageSync($config.cachePrefix + 'token');
        config.header.Authorization = validator.isEmpty(token) ? '' : 'Bearer ' + token;
        return config
    }, (config) => // 可使用async await 做异步操作
        Promise.reject(config))
}
