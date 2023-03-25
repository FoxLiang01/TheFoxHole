import request from '@/utils/request'

// 查询连载文章列表
export function listWork(query) {
  return request({
    url: '/business/work/list',
    method: 'get',
    params: query
  })
}

// 查询连载文章所有列表
export function listAllWork(query) {
  return request({
    url: '/business/work/listAll',
    method: 'get',
    params: query
  })
}

// 查询连载文章详细
export function getWork(id) {
  return request({
    url: '/business/work/getInfo/' + id,
    method: 'get'
  })
}

// 新增连载文章
export function addWork(data) {
  return request({
    url: '/business/work/add',
    method: 'post',
    data: data
  })
}

// 修改连载文章
export function updateWork(data) {
  return request({
    url: '/business/work/edit',
    method: 'post',
    data: data
  })
}

// 删除连载文章
export function delWork(id) {
  return request({
    url: '/business/work/remove/' + id,
    method: 'get'
  })
}
