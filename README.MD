快速入门
========


基本概念
-------


针对每个接口的请求流程如下：

1. 根据功能需求确认接口
2. 确认请求参数


.. note::

    POST及GET请求都是以JSON形式提交或者返回

    建议使用POSTMAN进行本地测试

    PMS 获取当前登录用户的信息的接口:/user/getcurrentuser,获取当前登陆用户的信息包含:
    email,该用户对应的departmentId.
    该登陆用户如果对应的部门为多个,则departmentId需要'|'分割.如'11|16|17',表示商户端,基金,北研.默认请选中第一个编号对应的部门.
    无部门为none.拥有全部部门的权限的则为all.

    某一个登陆用户对应的权限,一般为add|query,全部权限则为all,没有任何权限为forbidden

    只需要获得code来判断当前登录用户是否拥有创建和更新的权限即可,若code=200则表示有权限,code=403则不能给予添加和更新的权限


返回值code列表
-------------

    在每个请求的返回的json串中,新增了一个名为code的int类型,说明列表如下:

    =========       ================================================================
    code            说明
    =========       ================================================================
    200             调用API接口成功
    300             调用API接口成功,但是无返回值
    401             调用API接口失败,返回SSO未登陆错误,需要跳转到http://sso.ele.me登陆
    403             调用API接口失败,返回无权限访问API接口错误
    500             调用API接口失败,服务器端代码异常,需要查看etrace信息
    =========       ================================================================

    401,403,500错误需要在ajax中自定义error:function接受返回信息,实例代码如下:

    401举例:

    error:function (result) {
        if (JSON.parse(result.responseText).code == 401) {
            window.location.href = "http://sso.ele.me";}}

模型信息列表
----------

    部门信息

    .. _department:

    ===============            ======= ==========================================
    参数名                      类型    描述
    ===============            ======= ==========================================
    departmentId               int     自增长主键,部门编号
    departmentName             String  部门名称,含索引,默认值为test-department
    departmentOwner            String  部门Owner
    ===============            ======= ==========================================


    产品线信息

    .. _product-Line:

    =================          ======== ================================================================================
    参数名                      类型     描述
    =================          ======== ================================================================================
    productLineId              int      自增长主键,产品线编号
    productLineName            String   产品线名称,含索引,默认值为test-productline
    productLineOwner           String   产品线Owner
    departmentId               String   产品线所属部门编号
    appId                      String   AppId
    sequenceNo                 int      按照不同的部门编号进行序列排序的编号,从10开始累加计算
    maintenanceNo              int      部门编号+序列排序编号,如外卖平台部门编号为10,

                                        产品线外卖平台website的序列号为10,

                                        则此编号为1010.产品线外卖平台app的序列号为11,则此编号为1011
    transfer                   boolean  该产品线是否转到其他部门,默认值为false
    =================          ======== ================================================================================


    产品信息

    .. _product:

    ===============            ======== ================================================================================
    参数名                      类型      描述
    ===============            ======== ================================================================================
    productId                  int      自增长主键,产品编号
    productName                String   产品名称,含索引,默认值为test-productname
    productOwner               String   产品Owner
    departmentId               int      产品线所属部门编号
    productLineId              int      产品所属产品线编号
    appId                      String   AppId
    sequenceNo                 int      按照不同的部门编号进行序列排序的编号,从10开始累加计算
    maintenanceNo              int      部门编号+产品线maintenanceNo+序列排序编号,如外卖平台部门编号为10,

                                        产品线外卖平台website的maintenanceNo为1010,

                                        则此编号为101010.产品线外卖平台app的maintenanceNo为1011,则此编号为101110
    transfer                   boolean  该产品是否转到其他部门,默认值为false
    ===============            ======== ================================================================================


    模块信息

    .. _module:

    ===============            ======== ================================================================================
    参数名                      类型     描述
    ===============            ======== ================================================================================
    moduleId                   int      自增长主键,模块编号
    moduleName                 String   模块名称,含索引
    moduleOwner                String   模块Owner
    departmentId               int      模块所属部门编号
    productLineId              int      模块所属产品线编号
    producId                   int      模块所属产品编号
    appId                      String   AppId
    sequenceNo                 int      按照不同的部门编号进行序列排序的编号,从10开始累加计算
    maintenanceNo              int      部门编号+产品线maintenanceNo+产品maintenanceNo+序列排序编号
    transfer                   boolean  该模块是否转到其他部门,默认值为false
    critical                   boolean  该模块是否为关键路径,默认值为false
    appType                    String   该模块类型,如:java-app,java-tomcat
    portNo                     int      该模块端口号
    elog                       boolean  该某块是否接入elog,默认值为false
    soa                        boolean  该某块是否接入soa,默认值为false
    dal                        boolean  该某块是否接入dal,默认值为false
    soaVersion                 String   接入soa的版本信息
    dalVersion                 String   接入dal的版本信息
    eless                      boolean  该模块是否接入eless(发布系统),默认值为false
    moduleStatus               boolean  该模块当前状态是否可用
    ===============            ======== ================================================================================

* alpha 环境上api地址:http://vpca-pmo-api-1.vm.elenet.me:8028/pmo.api/

* beta 环境上api地址:http://vpcb-pmo-api-1.vm.elenet.me:8028/pmo.api/

各个环境请按照各自地址进行调用


HTTP RESTFUL API接口
---------------------

        * 部门信息接口:

            URL:http://192.168.80.30:8080/pmo.api/department/方法名/参数值(只针对GET请求)

            1. 添加部门信息:

            * 方法名:adddepartment

            * Method:POST
                * Body:
                    {
                    "departmentName":"testdepartmen",
                    "departmentOwner":"taizhou.wang@ele.me",
                    "createdBy":"gang.gush@ele.me"
                    }

            * 返回值:
                {"resultMsg":"true","successed":true,"code":200}


            2. 更新部门信息:

            * 方法名:updatedepartment

            * Method:POST
                * Body:
                    {
                    "departmentId":2,
                    "departmentName":"testdepartment-1",
                    "departmentOwner":"run.zhao@ele.me",
                    "updatedBy":"li.wang02@ele.me"
                    }

            * 返回值:
                {"resultMsg":"true","successed":true,"code":200}


            3. 获取部门列表信息:

            * 方法名:queryall

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    [
                    {"departmentId":1,"departmentName":"dep1","departmentOwner":"taizhou.wang@ele.me",
                    "createdBy":"gang.gush@ele.me","updatedBy":null},

                    {"departmentId":2,"departmentName":"dep2","departmentOwner":"run.zhao@ele.me",
                    "createdBy":"xin.han@ele.me","updatedBy":"li.wang02@ele.me"}
                    ],

                    "code":200
                }


            4. 根据部门编号查询部门信息:

            * 方法名:getbydepartmentid

            * 参数departmentid

            * Method: GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"departmentId":1,"departmentName":"dep1","departmentOwner":"taizhou.wang@ele.me",
                    "createdBy":"gang.gush@ele.me","updatedBy":null},

                    "code":200
                }


            5. 根据部门名称查询部门信息:

            * 方法名:getbydepartmentname

            * 参数:departmentname

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"departmentId":2,"departmentName":"dep1","departmentOwner":"run.zhao@ele.me",
                    "createdBy":"xin.han@ele.me","updatedBy":"li.wang02@ele.me"},

                    "code":200
                }


            6. 模糊的部门名称查询出相应的部门信息:

            * 方法名:getcontainsdepartmentname

            * 参数:departmentname

            * Method:GET
                * Body:空

            * 返回值:
                {
                    "successed":true,

                    "resultMsg":
                    [
                    {"departmentId":2,"departmentName":"dep","departmentOwner":"run.zhao@ele.me",
                    "createdBy":"xin.han@ele.me","updatedBy":"li.wang02@ele.me"}
                    ],

                    "code":200
                }



        * 产品线信息接口:

            URL:http://192.168.80.30:8080/pmo.api/productline/方法名/参数值(只针对GET请求)

            1. 添加新的产品线信息:

            * 方法名:addproductline

            * Method:POST
                * Body:
                    {
                    "productLineName":"pln",
                    "productLineOwner":"plnow",
                    "appId":"pln-1",
                    "createdBy":"gang.gush@ele.me",
                    "department":{"departmentId":1}
                    }

            * 返回值:
                {"resultMsg":"true","successed":true,"code":200}


            2. 更新现有的产品线信息:

            * 方法名:updateproductline

            * Method:POST
                * Body:
                    {
                    "productLineId":1,
                    "productLineName":"pln",
                    "productLineOwner":"plnow",
                    "appId":"pln-1",
                    "updatedBy":"gang.gush@ele.me",
                    "department":{"departmentId":1}
                    }

            * 返回值：
                {"resultMsg":"true","successed":true,"code":200}


            3. 查询全部产品线信息:

            * 方法名:queryall

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    [
                        {"productLineId":4,
                        "productLineName":"外卖平台Desktop",
                        "productLineOwner":"taizhou.wang@ele.me",
                        "department":
                        {"departmentId":10,"departmentName":"外卖平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":10,"appId":"waimai.desktop.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":11,"maintenanceNo":1011,"transfer":false},

                        {"productLineId":3,
                        "productLineName":"商户端平台Desktop","productLineOwner":"run.zhao@ele.me",
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,"appId":"napos.desktop.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":11,"maintenanceNo":1111,"transfer":false},

                        {"productLineId":2,
                        "productLineName":"商户端平台App",
                        "productLineOwner":"run.zhao@ele.me",
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,"appId":"napos.app.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":10,"maintenanceNo":1110,"transfer":false},

                        {"productLineId":1,
                        "productLineName":"外卖平台App",
                        "productLineOwner":"taizhou.wang@ele.me",
                        "department":
                        {"departmentId":10,"departmentName":"外卖平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":10,"appId":"waimai.app.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":10,"maintenanceNo":1010,"transfer":false}
                    ],

                    "code":200
                }


            4. 根据产品线编号查询产品线信息:

            * 方法名:getbyproductlineid

            * 参数名:productLineId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                        {"productLineId":2,
                        "productLineName":"商户端平台App",
                        "productLineOwner":"run.zhao@ele.me",
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,
                        "appId":"napos.app.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":10,"maintenanceNo":1110,"transfer":false},

                    "code":200
                }


            5. 根据产品线名称查询产品线信息:

            * 方法名:getbyproductlinename

            * 参数名:productLineName

            * Method: GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                        {"productLineId":2,
                        "productLineName":"商户端平台App",
                        "productLineOwner":"run.zhao@ele.me",
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,
                        "appId":"napos.app.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":10,"maintenanceNo":1110,"transfer":false},

                    "code":200
                }


            6. 模糊的产品线名称查询出相应的产品线信息:

            * 方法名:getcontainsproductlinename

            * 参数名:productLineName

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                        {"productLineId":2,
                        "productLineName":"商户端平台App",
                        "productLineOwner":"run.zhao@ele.me",
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,
                        "appId":"napos.app.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":10,"maintenanceNo":1110,"transfer":false},

                    "code":200
                }


            7. 根据产品线所对应的部门编号查询出产品线信息:

            * 方法名:getbydepartmentid

            * 参数名:departmentId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                        {"productLineId":2,
                        "productLineName":"商户端平台App",
                        "productLineOwner":"run.zhao@ele.me",
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,
                        "appId":"napos.app.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":10,"maintenanceNo":1110,"transfer":false},

                    "code":200
                }

            8. 根据AppId查询产品线信息:

            * 方法名:getbyappid

            * Method:POST
                * Body:
                    {"appId":"appId"}

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                        {"productLineId":2,
                        "productLineName":"商户端平台App",
                        "productLineOwner":"run.zhao@ele.me",
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,
                        "appId":"napos.app.ele.me","createdBy":null,
                        "updatedBy":null,
                        "sequenceNo":10,"maintenanceNo":1110,"transfer":false},

                    "code":200
                }



        * 产品信息接口:

            URL:http://192.168.80.30:8080/pmo.api/product/方法名/参数值(只针对GET请求)

            1. 添加新的产品信息:

            * 方法名:addproduct

            * Method:POST
                * Body:
                    {
                    "productName":"pln",
                    "productOwner":"plnow",
                    "appId":"pln-1",
                    "createdBy":"gang.gush@ele.me",
                    "productLine":{"productLineId":1},
                    "department":{"departmentId":1}
                    }

            * 返回值:
                {"resultMsg":"true","successed":true,"code":200}


            2. 更新现有的产品信息:

            * 方法名:updateproduct

            * Method:POST
                * Body:
                    {
                    "productId":2,
                    "productName":"p-2",
                    "productOwner":"po-1",
                    "appId":"p-1",
                    "updatedBy":"gang.gush@ele.me",
                    "productLine":{"productLineId":1},
                    "department":{"departmentId":2}
                    }

            * 返回值：
                {"resultMsg":"true","successed":true,"code":200}


            3. 查询全部产品信息:

            * 方法名:queryall

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    [
                        {"productId":6,
                        "productName":"商户端平台Desktop",
                        "productOwner":"run.zhao@ele.me",
                        "productLine":
                        {"productLineId":1111,"productLineName":"商户端平台Desktop",
                        "productLineOwner":"run.zhao@ele.me",
                        "department":null,"departmentId":0,"appId":null,"createdBy":null,
                        "updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                        "productLineId":1111,
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,"appId":"napos.desktop.ele.me","createdBy":null,
                        "updatedBy":null,"sequenceNo":10,"maintenanceNo":111110,"transfer":false},

                        {"productId":5,
                        "productName":"商户端平台App-iOS",
                        "productOwner":"run.zhao@ele.me",
                        "productLine":
                        {"productLineId":1110,"productLineName":"商户端平台App",
                        "productLineOwner":"run.zhao@ele.me","department":null,
                        "departmentId":0,"appId":null,"createdBy":null,
                        "updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                        "productLineId":1110,
                        "department":
                        {"departmentId":11,"departmentName":"商户端平台",
                        "departmentOwner":null,"createdBy":null,"updatedBy":null},
                        "departmentId":11,"appId":"napos.app.iOS.ele.me","createdBy":null,
                        "updatedBy":null,"sequenceNo":11,"maintenanceNo":111011,"transfer":false}
                    ],

                    "code":200
                }


            4. 根据产品编号查询产品信息:

            * 方法名:getbyproductid

            * 参数名:productId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"productId":2,
                    "productName":"外卖平台App-iOS",
                    "productOwner":"taizhou.wang@ele.me",
                    "productLine":
                    {"productLineId":1010,"productLineName":"外卖平台App",
                    "productLineOwner":"taizhou.wang@ele.me",
                    "department":null,"departmentId":0,"appId":null,
                    "createdBy":null,"updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                    "productLineId":1010,
                    "department":
                    {"departmentId":10,"departmentName":"外卖平台","departmentOwner":null,"createdBy":null,"updatedBy":null},
                    "departmentId":10,"appId":"waimai.app.iOS.ele.me","createdBy":null,"updatedBy":null,
                    "sequenceNo":10,"maintenanceNo":101010,"transfer":false},

                    "code":200
                }


            5. 根据产品名称查询产品信息:

            * 方法名:getbyproductname

            * 参数名:productName

            * Method: GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"productId":2,
                    "productName":"外卖平台App-iOS",
                    "productOwner":"taizhou.wang@ele.me",
                    "productLine":
                    {"productLineId":1010,"productLineName":"外卖平台App",
                    "productLineOwner":"taizhou.wang@ele.me",
                    "department":null,"departmentId":0,"appId":null,
                    "createdBy":null,"updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                    "productLineId":1010,
                    "department":
                    {"departmentId":10,"departmentName":"外卖平台","departmentOwner":null,"createdBy":null,"updatedBy":null},
                    "departmentId":10,"appId":"waimai.app.iOS.ele.me","createdBy":null,"updatedBy":null,
                    "sequenceNo":10,"maintenanceNo":101010,"transfer":false},

                    "code":200
                }


            6. 模糊的产品名称查询出相应的产品信息:

            * 方法名:getcontainsproductname

            * 参数名:productName

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"productId":2,
                    "productName":"外卖平台App-iOS",
                    "productOwner":"taizhou.wang@ele.me",
                    "productLine":
                    {"productLineId":1010,"productLineName":"外卖平台App",
                    "productLineOwner":"taizhou.wang@ele.me",
                    "department":null,"departmentId":0,"appId":null,
                    "createdBy":null,"updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                    "productLineId":1010,
                    "department":
                    {"departmentId":10,"departmentName":"外卖平台","departmentOwner":null,"createdBy":null,"updatedBy":null},
                    "departmentId":10,"appId":"waimai.app.iOS.ele.me","createdBy":null,"updatedBy":null,
                    "sequenceNo":10,"maintenanceNo":101010,"transfer":false},

                    "code":200
                }


            7. 根据产品所对应的部门编号查询出产品信息:

            * 方法名:getbydepartmentid

            * 参数名:departmentId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"productId":2,
                    "productName":"外卖平台App-iOS",
                    "productOwner":"taizhou.wang@ele.me",
                    "productLine":
                    {"productLineId":1010,"productLineName":"外卖平台App",
                    "productLineOwner":"taizhou.wang@ele.me",
                    "department":null,"departmentId":0,"appId":null,
                    "createdBy":null,"updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                    "productLineId":1010,
                    "department":
                    {"departmentId":10,"departmentName":"外卖平台","departmentOwner":null,"createdBy":null,"updatedBy":null},
                    "departmentId":10,"appId":"waimai.app.iOS.ele.me","createdBy":null,"updatedBy":null,
                    "sequenceNo":10,"maintenanceNo":101010,"transfer":false},

                    "code":200
                }


            8. 根据AppId查询产品信息:

            * 方法名:getbyappid

            * Method:POST
                * Body:
                    {"appId":"appId"}

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"productId":2,
                    "productName":"外卖平台App-iOS",
                    "productOwner":"taizhou.wang@ele.me",
                    "productLine":
                    {"productLineId":1010,"productLineName":"外卖平台App",
                    "productLineOwner":"taizhou.wang@ele.me",
                    "department":null,"departmentId":0,"appId":null,
                    "createdBy":null,"updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                    "productLineId":1010,
                    "department":
                    {"departmentId":10,"departmentName":"外卖平台","departmentOwner":null,"createdBy":null,"updatedBy":null},
                    "departmentId":10,"appId":"waimai.app.iOS.ele.me","createdBy":null,"updatedBy":null,
                    "sequenceNo":10,"maintenanceNo":101010,"transfer":false},

                    "code":200
                }


            9. 根据产品所对应的产品线编号查询产品信息:

            * 方法名:getbyproductlineid

            * 参数名:productLineId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed":true,

                    "resultMsg":
                    {"productId":2,
                    "productName":"外卖平台App-iOS",
                    "productOwner":"taizhou.wang@ele.me",
                    "productLine":
                    {"productLineId":1010,"productLineName":"外卖平台App",
                    "productLineOwner":"taizhou.wang@ele.me",
                    "department":null,"departmentId":0,"appId":null,
                    "createdBy":null,"updatedBy":null,"sequenceNo":0,"maintenanceNo":0,"transfer":false},
                    "productLineId":1010,
                    "department":
                    {"departmentId":10,"departmentName":"外卖平台","departmentOwner":null,"createdBy":null,"updatedBy":null},
                    "departmentId":10,"appId":"waimai.app.iOS.ele.me","createdBy":null,"updatedBy":null,
                    "sequenceNo":10,"maintenanceNo":101010,"transfer":false},

                    "code":200
                }



        * 模块信息接口:

            URL:http://192.168.80.30:8080/pmo.api/module/方法名/参数值(只针对GET请求)

            1. 添加新的模块信息:

            * 方法名:addmodule

            * Method:POST
                * Body:
                    {
                    "moduleName":"m-1",
                    "moduleOwner":"mo-1",
                    "createdBy":"gang.gush@ele.me",
                    "appId":"m-1-1",
                    "product":{"productId":1},
                    "productLine":{"productLineId":2},
                    "department":{"departmentId":2}
                    }

            * 返回值:
                {"resultMsg":"true","successed":true,"code":200}


            2. 更新现有的模块信息:

            * 方法名:updatemodule

            * Method:POST
                * Body:
                    {
                    "moduleId":1,
                    "moduleName":"m-2",
                    "moduleOwner":"mo-1",
                    "updatedBy":"gang.gush@ele.me",
                    "appId":"m-1-2",
                    "product":{"productId":1},
                    "productLine":{"productLineId":1},
                    "department":{"departmentId":2}
                    }

            * 返回值：
                {"resultMsg":"true","successed":true,"code":200}


            3. 查询全部模块信息:

            * 方法名:queryall

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": [
                        {
                            "moduleId": 1,
                            "moduleName": "外卖平台-红包功能模块",
                            "moduleOwner": "chen.shi@ele.me",
                            "productLine": {
                                "productLineId": 1010,
                                "productLineName": "外卖平台App",
                                "productLineOwner": "taizhou.wang@ele.me",
                                "department": null,
                                "departmentId": 0,
                                "appId": null,
                                "createdBy": null,
                                "updatedBy": null,
                                "sequenceNo": 0,
                                "maintenanceNo": 0,
                                "transfer": false
                            },
                            "productLineId": 1010,
                            "product": {
                                "productId": 101010,
                                "productName": "外卖平台App-iOS",
                                "productOwner": "taizhou.wang@ele.me",
                                "productLine": null,
                                "productLineId": 0,
                                "department": null,
                                "departmentId": 0,
                                "appId": null,
                                "createdBy": null,
                                "updatedBy": null,
                                "sequenceNo": 0,
                                "maintenanceNo": 0,
                                "transfer": false
                            },
                            "productId": 101010,
                            "department": {
                                "departmentId": 10,
                                "departmentName": "外卖平台",
                                "departmentOwner": null,
                                "createdBy": null,
                                "updatedBy": null
                            },
                            "departmentId": 10,
                            "appId": "hongbao.waimai.ele.me",
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 10,
                            "maintenanceNo": 10101010,
                            "critical": true,
                            "transfer": false
                        }
                    ],

                    "code": 200
                }


            4. 根据模块编号查询模块信息:

            * 方法名:getbymoduleid

            * 参数名:moduleId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": {
                        "moduleId": 1,
                        "moduleName": "外卖平台-红包功能模块",
                        "moduleOwner": "chen.shi@ele.me",
                        "productLine": {
                            "productLineId": 1010,
                            "productLineName": "外卖平台App",
                            "productLineOwner": "taizhou.wang@ele.me",
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productLineId": 1010,
                        "product": {
                            "productId": 101010,
                            "productName": "外卖平台App-iOS",
                            "productOwner": "taizhou.wang@ele.me",
                            "productLine": null,
                            "productLineId": 0,
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productId": 101010,
                        "department": {
                            "departmentId": 10,
                            "departmentName": "外卖平台",
                            "departmentOwner": null,
                            "createdBy": null,
                            "updatedBy": null
                        },
                        "departmentId": 10,
                        "appId": "hongbao.waimai.ele.me",
                        "createdBy": null,
                        "updatedBy": null,
                        "sequenceNo": 10,
                        "maintenanceNo": 10101010,
                        "critical": true,
                        "transfer": false
                    },

                    "code": 200
                }


            5. 根据模块名称查询模块信息:

            * 方法名:getbymodulename

            * 参数名:moduleName

            * Method: GET
                * Body:空

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": {
                        "moduleId": 1,
                        "moduleName": "外卖平台-红包功能模块",
                        "moduleOwner": "chen.shi@ele.me",
                        "productLine": {
                            "productLineId": 1010,
                            "productLineName": "外卖平台App",
                            "productLineOwner": "taizhou.wang@ele.me",
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productLineId": 1010,
                        "product": {
                            "productId": 101010,
                            "productName": "外卖平台App-iOS",
                            "productOwner": "taizhou.wang@ele.me",
                            "productLine": null,
                            "productLineId": 0,
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productId": 101010,
                        "department": {
                            "departmentId": 10,
                            "departmentName": "外卖平台",
                            "departmentOwner": null,
                            "createdBy": null,
                            "updatedBy": null
                        },
                        "departmentId": 10,
                        "appId": "hongbao.waimai.ele.me",
                        "createdBy": null,
                        "updatedBy": null,
                        "sequenceNo": 10,
                        "maintenanceNo": 10101010,
                        "critical": true,
                        "transfer": false
                    },

                    "code": 200
                }


            6. 模糊的模块名称查询出相应的模块信息:

            * 方法名:getcontainsmodulename

            * 参数名:moduleName

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": {
                        "moduleId": 1,
                        "moduleName": "外卖平台-红包功能模块",
                        "moduleOwner": "chen.shi@ele.me",
                        "productLine": {
                            "productLineId": 1010,
                            "productLineName": "外卖平台App",
                            "productLineOwner": "taizhou.wang@ele.me",
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productLineId": 1010,
                        "product": {
                            "productId": 101010,
                            "productName": "外卖平台App-iOS",
                            "productOwner": "taizhou.wang@ele.me",
                            "productLine": null,
                            "productLineId": 0,
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productId": 101010,
                        "department": {
                            "departmentId": 10,
                            "departmentName": "外卖平台",
                            "departmentOwner": null,
                            "createdBy": null,
                            "updatedBy": null
                        },
                        "departmentId": 10,
                        "appId": "hongbao.waimai.ele.me",
                        "createdBy": null,
                        "updatedBy": null,
                        "sequenceNo": 10,
                        "maintenanceNo": 10101010,
                        "critical": true,
                        "transfer": false
                    },

                    "code": 200
                }


            7. 根据模块所对应的部门编号查询出模块信息:

            * 方法名:getbydepartmentid

            * 参数名:departmentId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": {
                        "moduleId": 1,
                        "moduleName": "外卖平台-红包功能模块",
                        "moduleOwner": "chen.shi@ele.me",
                        "productLine": {
                            "productLineId": 1010,
                            "productLineName": "外卖平台App",
                            "productLineOwner": "taizhou.wang@ele.me",
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productLineId": 1010,
                        "product": {
                            "productId": 101010,
                            "productName": "外卖平台App-iOS",
                            "productOwner": "taizhou.wang@ele.me",
                            "productLine": null,
                            "productLineId": 0,
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productId": 101010,
                        "department": {
                            "departmentId": 10,
                            "departmentName": "外卖平台",
                            "departmentOwner": null,
                            "createdBy": null,
                            "updatedBy": null
                        },
                        "departmentId": 10,
                        "appId": "hongbao.waimai.ele.me",
                        "createdBy": null,
                        "updatedBy": null,
                        "sequenceNo": 10,
                        "maintenanceNo": 10101010,
                        "critical": true,
                        "transfer": false
                    },

                    "code": 200
                }


            8. 根据AppId查询模块信息:

            * 方法名:getbyappid

            * Method:POST
                * Body:
                    {"appId":"appId"}

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": {
                        "moduleId": 1,
                        "moduleName": "外卖平台-红包功能模块",
                        "moduleOwner": "chen.shi@ele.me",
                        "productLine": {
                            "productLineId": 1010,
                            "productLineName": "外卖平台App",
                            "productLineOwner": "taizhou.wang@ele.me",
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productLineId": 1010,
                        "product": {
                            "productId": 101010,
                            "productName": "外卖平台App-iOS",
                            "productOwner": "taizhou.wang@ele.me",
                            "productLine": null,
                            "productLineId": 0,
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productId": 101010,
                        "department": {
                            "departmentId": 10,
                            "departmentName": "外卖平台",
                            "departmentOwner": null,
                            "createdBy": null,
                            "updatedBy": null
                        },
                        "departmentId": 10,
                        "appId": "hongbao.waimai.ele.me",
                        "createdBy": null,
                        "updatedBy": null,
                        "sequenceNo": 10,
                        "maintenanceNo": 10101010,
                        "critical": true,
                        "transfer": false
                    },

                    "code": 200
                }


            9. 根据模块所对应的产品线编号查询模块信息:

            * 方法名:getbyproductlineid

            * 参数名:productLineId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": {
                        "moduleId": 1,
                        "moduleName": "外卖平台-红包功能模块",
                        "moduleOwner": "chen.shi@ele.me",
                        "productLine": {
                            "productLineId": 1010,
                            "productLineName": "外卖平台App",
                            "productLineOwner": "taizhou.wang@ele.me",
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productLineId": 1010,
                        "product": {
                            "productId": 101010,
                            "productName": "外卖平台App-iOS",
                            "productOwner": "taizhou.wang@ele.me",
                            "productLine": null,
                            "productLineId": 0,
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productId": 101010,
                        "department": {
                            "departmentId": 10,
                            "departmentName": "外卖平台",
                            "departmentOwner": null,
                            "createdBy": null,
                            "updatedBy": null
                        },
                        "departmentId": 10,
                        "appId": "hongbao.waimai.ele.me",
                        "createdBy": null,
                        "updatedBy": null,
                        "sequenceNo": 10,
                        "maintenanceNo": 10101010,
                        "critical": true,
                        "transfer": false
                    },

                    "code": 200
                }

            10. 根据模块所对应的产品编号查询模块信息:

            * 方法名:getbyproductid

            * 参数名:productId

            * Method:GET
                * Body:空

            * 返回值:

                {
                    "successed": true,

                    "resultMsg": {
                        "moduleId": 1,
                        "moduleName": "外卖平台-红包功能模块",
                        "moduleOwner": "chen.shi@ele.me",
                        "productLine": {
                            "productLineId": 1010,
                            "productLineName": "外卖平台App",
                            "productLineOwner": "taizhou.wang@ele.me",
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productLineId": 1010,
                        "product": {
                            "productId": 101010,
                            "productName": "外卖平台App-iOS",
                            "productOwner": "taizhou.wang@ele.me",
                            "productLine": null,
                            "productLineId": 0,
                            "department": null,
                            "departmentId": 0,
                            "appId": null,
                            "createdBy": null,
                            "updatedBy": null,
                            "sequenceNo": 0,
                            "maintenanceNo": 0,
                            "transfer": false
                        },
                        "productId": 101010,
                        "department": {
                            "departmentId": 10,
                            "departmentName": "外卖平台",
                            "departmentOwner": null,
                            "createdBy": null,
                            "updatedBy": null
                        },
                        "departmentId": 10,
                        "appId": "hongbao.waimai.ele.me",
                        "createdBy": null,
                        "updatedBy": null,
                        "sequenceNo": 10,
                        "maintenanceNo": 10101010,
                        "critical": true,
                        "transfer": false
                    },

                    "code": 200
                }



SOA API接口
---------------------
    * 基本概念

    SOA 接口需要引入服务端提供的.jar文件(me.ele.pmo.pms.facade.jar, 包含接口定义及表对应的model信息),并参考框架接入SOA的文档进行开发,需要一定的java语言基础.


        * 部门信息接口

                新增部门

                boolean addDepartment(Department department);

                更新部门

                boolean updateDepartment(Department department);

                根据部门编号获取部门信息

                Department getByDepartmentId(int departmentId);

                根据部门名称获取部门信息

                Department getByDepartmentName(String departmentName);

                查询全部部门信息

                List<Department> queryAll();

                根据部门名称模糊查询

                List<Department> getContainsDepartmentName(String departmentName);


        * 产品线信息接口

                新增产品线

                boolean addProductLine(ProductLine productLine);

                更新产品线

                boolean updateProductLine(ProductLine productLine);

                根据产品线编号获取产品线信息

                ProductLine getByProductLineId(int productLineId);

                根据产品线名称获取产品线信息

                ProductLine getByProductLineName(String productLineName);

                查询全部产品线信息

                List<ProductLine> queryAll();

                模糊的产品线名称查询出相应的产品线信息

                List<ProductLine> getContainsProductLineName(String productLineName);

                产品线所属的部门编号查询产品线信息

                List<ProductLine> getByDepartmentId(int departmentId);

                根据产品线绑定的appid查询产品线信息

                List<ProductLine> getByAppId(String appId);


        * 产品信息接口

                新增产品

                boolean addProduct(Product product);

                更新产品

                boolean updateProduct(Product product);

                根据产品编号获取产品信息

                Product getByProductId(int productId);

                根据产品名称获取产品信息

                Product getByProductName(String productName);

                查询全部产品信息

                List<Product> queryAll();

                模糊的产品名称查询出相应的产品信息

                List<Product> getContainsProductName(String productName);

                根据产品所对应的部门编号查询产品信息

                List<Product> getByDepartmentId(int departmentId);

                根据产品所对应的产品线编号查询产品信息

                List<Product> getByProductLineId(int productLineId);

                根据产品绑定的AppId查询产品信息

                List<Product> getByAppId(String appId);


        * 模块信息接口

                新增模块

                boolean addModule(Module module);

                更新模块

                boolean updateModule(Module module);

                根据模块编号查询模块信息

                Module getByModuleId(int moduleId);

                根据模块名称查询模块信息

                Module getByModuleName(String moduleName);

                查询全部模块信息

                List<Module> queryAll();

                模糊的模块名称查询出相应的模块信息

                List<Module> getContainsModuleName(String moduleName);

                根据模块所对应的部门编号查询模块信息

                List<Module> getByDepartmentId(int departmentId);

                根据模块所对应的产品线编号查询模块信

                List<Module> getByProductLineId(int productLineId);

                根据模块所对应的产品编号查询模块信息

                List<Module> getByProductId(int productId);

                根据AppId查询模块信息

                List<Module> getByAppId(String appId);
