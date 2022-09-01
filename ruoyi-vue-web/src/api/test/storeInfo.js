import request from '@/utils/request'

// 查询门店列表
export function listStoreInfo(query) {
  return request({
    url: '/test/storeInfo/list',
    method: 'get',
    params: query
  })
}

// 查询门店详细
export function getStoreInfo(id) {
  return request({
    url: '/test/storeInfo/getInfo/' + id,
    method: 'get'
  })
}

// 新增门店
export function addStoreInfo(data) {
  return request({
    url: '/test/storeInfo/add',
    method: 'post',
    data: data
  })
}

// 修改门店
export function updateStoreInfo(data) {
  return request({
    url: '/test/storeInfo/edit',
    method: 'post',
    data: data
  })
}

// 删除门店
export function delStoreInfo(id) {
  return request({
    url: '/test/storeInfo/remove/' + id,
    method: 'get'
  })
}
