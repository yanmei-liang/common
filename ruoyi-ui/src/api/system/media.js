import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listMedia(query) {
  return request({
    url: '/system/media/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getMedia(id) {
  return request({
    url: '/system/media/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addMedia(data) {
  return request({
    url: '/system/media',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateMedia(data) {
  return request({
    url: '/system/media',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delMedia(id) {
  return request({
    url: '/system/media/' + id,
    method: 'delete'
  })
}
