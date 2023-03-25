import request from '@/utils/request'

// 查询合集列表
export function listCategory(query) {
  return request({
    url: '/business/category/list',
    method: 'get',
    params: query
  })
}

// 查询合集所有列表
export function listAllCategory(query) {
  return request({
    url: '/business/category/listAll',
    method: 'get',
    params: query
  })
}

// 查询合集详细
export function getCategory(id) {
  return request({
    url: '/business/category/getInfo/' + id,
    method: 'get'
  })
}

// 新增合集
export function addCategory(data) {
  return request({
    url: '/business/category/add',
    method: 'post',
    data: data
  })
}

// 修改合集
export function updateCategory(data) {
  return request({
    url: '/business/category/edit',
    method: 'post',
    data: data
  })
}

// 删除合集
export function delCategory(id) {
  return request({
    url: '/business/category/remove/' + id,
    method: 'get'
  })
}
