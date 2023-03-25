import request from '@/utils/request'

// 查询标签列表
export function listTag(query) {
  return request({
    url: '/business/tag/list',
    method: 'get',
    params: query
  })
}

// 查询标签所有列表
export function listAllTag(query) {
  return request({
    url: '/business/tag/listAll',
    method: 'get',
    params: query
  })
}

// 查询标签详细
export function getTag(id) {
  return request({
    url: '/business/tag/getInfo/' + id,
    method: 'get'
  })
}

// 新增标签
export function addTag(data) {
  return request({
    url: '/business/tag/add',
    method: 'post',
    data: data
  })
}

// 修改标签
export function updateTag(data) {
  return request({
    url: '/business/tag/edit',
    method: 'post',
    data: data
  })
}

// 删除标签
export function delTag(id) {
  return request({
    url: '/business/tag/remove/' + id,
    method: 'get'
  })
}
