import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listDm(query) {
  return request({
    url: '/system/dm/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getDm(id) {
  return request({
    url: '/system/dm/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addDm(data) {
  return request({
    url: '/system/dm',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateDm(data) {
  return request({
    url: '/system/dm',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delDm(id) {
  return request({
    url: '/system/dm/' + id,
    method: 'delete'
  })
}
