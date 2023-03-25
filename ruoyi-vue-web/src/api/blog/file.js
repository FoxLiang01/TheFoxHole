import request from '@/utils/request'

// 查询文件列表
export function listFile(query) {
  return request({
    url: '/business/file/list',
    method: 'get',
    params: query
  })
}

// 查询文件所有列表
export function listAllFile(query) {
  return request({
    url: '/business/file/listAll',
    method: 'get',
    params: query
  })
}

// 查询文件详细
export function getFile(id) {
  return request({
    url: '/business/file/getInfo/' + id,
    method: 'get'
  })
}

// 新增文件
export function addFile(data) {
  return request({
    url: '/business/file/add',
    method: 'post',
    data: data
  })
}

// 修改文件
export function updateFile(data) {
  return request({
    url: '/business/file/edit',
    method: 'post',
    data: data
  })
}

// 删除文件
export function delFile(id) {
  return request({
    url: '/business/file/remove/' + id,
    method: 'get'
  })
}
