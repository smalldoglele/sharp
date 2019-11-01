var prefix = "/user"
$(function () {
    load();
});

function load() {
    $('#simple-table')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#toolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParamsType: "",
                // //设置为limit则会发送符合RESTFull格式的参数
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        pageNumber: params.pageNumber,
                        pageSize: params.pageSize,
                        userName: $('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                responseHandler: function (res) {
                    console.log(res);
                    return {
                        "total": res.result.total,//总数
                        "rows": res.result.records   //数据
                    };
                },
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'id',
                        title: '编号'
                    },
                    {
                        field: 'userName',
                        title: '用户名'
                    },
                    {
                        field: 'nickName',
                        title: '昵称',
                        width: '100px'
                    },
                    {
                        field: 'trueName',
                        title: '真实姓名'
                    },
                    {
                        field: 'email',
                        title: '邮件'
                    },
                    {
                        visible: false,
                        field: 'mobile',
                        title: '手机号码'
                    },
                    {
                        visible: false,
                        field: 'sex',
                        title: '性别'
                    },
                    {
                        visible: false,
                        field: 'birthDate',
                        title: '生日'
                    },
                    {
                        visible: true,
                        field: 'createTime',
                        title: '创建时间'
                    },
                    {
                        visible: false,
                        field: 'updateBy',
                        title: '更新者'
                    },
                    {
                        visible: false,
                        field: 'updateTime',
                        title: '更新时间'
                    },
                    {
                        visible: false,
                        field: 'deleted',
                        title: '删除标记'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'left',
                        formatter: function (value, row, index) {
                            var e = '<button class="btn btn-success btn-xs" onclick="edit(' + value + ')"><i class="ace-icon fa fa-pencil-square-o icon-only"></i></button> ';
                            var d = '<button class="btn btn-danger btn-xs"  onclick="del(' + value + ')"><i class="ace-icon fa fa-trash-o icon-only"></i></button>';
                            return e + (value != 1 ? d : '');
                        }
                    }]
            });
}

function reload() {
    var opt = {
        query: {
            type: $('.chosen-select').val(),
            name: $('#searchName').val()
        }
    }
    $('#simple-table').bootstrapTable('refresh', opt);
}

function add() {
    layer.open({
        type: 2,
        title: '新增',
        shadeClose: false,
        area: ['800px'],
        offset: '100px',
        content: prefix + '/edit',
        success: function (layero, index) {
            layer.iframeAuto(index);
        }
    });
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑',
        shadeClose: false,
        area: ['800px'],
        offset: '100px',
        content: prefix + '/edit?id=' + id,
        success: function (layero, index) {
            layer.iframeAuto(index);
        }
    });
}

function del(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/del",
            type: "post",
            data: {
                'id': id
            },
            success: function (data) {
                if (data.status) {
                    layer.msg("删除成功");
                    reload();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

