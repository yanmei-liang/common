import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listNews(query) {
  return request({
    url: '/system/news/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getNews(id) {
  return request({
    url: '/system/news/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addNews(data) {
  return request({
    url: '/system/news',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateNews(data) {
  return request({
    url: '/system/news',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delNews(id) {
  return request({
    url: '/system/news/' + id,
    method: 'delete'
  })
}
