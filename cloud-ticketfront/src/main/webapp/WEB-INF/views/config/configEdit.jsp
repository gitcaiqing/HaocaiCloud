<%--
  Created by IntelliJ IDEA.
  User: Kedacom
  Date: 2020/5/21
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="col-sm-6">

        <!-- 8. $BORDERED_FORM =============================================================================

                        Bordered form
        -->
        <form action="" class="panel form-horizontal form-bordered">
            <div class="panel-heading">
                <span class="panel-title">Bordered form</span>
            </div>
            <div class="panel-body no-padding-hr">
                <div class="form-group no-margin-hr panel-padding-h no-padding-t no-border-t">
                    <div class="row">
                        <label class="col-sm-4 control-label">Name:</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="form-group no-margin-hr no-margin-b panel-padding-h">
                    <div class="row">
                        <label class="col-sm-4 control-label">Email:</label>
                        <div class="col-sm-8">
                            <input type="email" name="email" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-footer text-right">
                <button class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</body>


</html>
