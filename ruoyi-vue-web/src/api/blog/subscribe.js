import request from '@/utils/request'

// 查询订阅列表
export function listSubscribe(query) {
  return request({
    url: '/business/subscribe/list',
    method: 'get',
    params: query
  })
}

// 查询订阅详细
export function getSubscribe(id) {
  return request({
    url: '/business/subscribe/' + id,
    method: 'get'
  })
}

// 新增订阅
export function addSubscribe(data) {
  return request({
    url: '/business/subscribe',
    method: 'post',
    data: data
  })
}

// 修改订阅
export function updateSubscribe(data) {
  return request({
    url: '/business/subscribe',
    method: 'put',
    data: data
  })
}

// 删除订阅
export function delSubscribe(id) {
  return request({
    url: '/business/subscribe/' + id,
    method: 'delete'
  })
}
