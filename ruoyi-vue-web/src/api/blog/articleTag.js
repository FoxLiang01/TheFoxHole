import request from '@/utils/request'

// 查询文章与标题的关联列表
export function listArticleTag(query) {
  return request({
    url: '/business/articleTag/list',
    method: 'get',
    params: query
  })
}

// 查询文章与标题的关联所有列表
export function listAllArticleTag(query) {
  return request({
    url: '/business/articleTag/listAll',
    method: 'get',
    params: query
  })
}

// 查询文章与标题的关联详细
export function getArticleTag(articleId) {
  return request({
    url: '/business/articleTag/getInfo/' + articleId,
    method: 'get'
  })
}

// 新增文章与标题的关联
export function addArticleTag(data) {
  return request({
    url: '/business/articleTag/add',
    method: 'post',
    data: data
  })
}

// 修改文章与标题的关联
export function updateArticleTag(data) {
  return request({
    url: '/business/articleTag/edit',
    method: 'post',
    data: data
  })
}

// 删除文章与标题的关联
export function delArticleTag(articleId) {
  return request({
    url: '/business/articleTag/remove/' + articleId,
    method: 'get'
  })
}
