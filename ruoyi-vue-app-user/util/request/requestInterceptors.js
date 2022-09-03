import $config from '@/common/config.js';
import {validator} from '@/common/validator.js';
import aes from './aes.js';

/**
 * 请求拦截
 * @param {Object} http
 */
module.exports = (vm) => {
    uni.$u.http.interceptors.request.use((config) => { // 可使用async await 做异步操作
        // 初始化请求拦截器时，会执行此方法，此时data为undefined，赋予默认{}
        if (!$config.aesEncryptEnabled) {
            config.data = config.data || {};
        } else {
            config.data = config.data || {noData: new Date().getTime()};
            let params = aes.encrypt(JSON.stringify(config.data));
            config.data = {
                aesData: encodeURIComponent(params)
            };
        }
        let token = uni.getStorageSync($config.cachePrefix + 'token');
        config.header.Authorization = validator.isEmpty(token) ? '' : 'Bearer ' + token;
        return config
    }, (config) => // 可使用async await 做异步操作
        Promise.reject(config))
}
