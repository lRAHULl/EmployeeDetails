<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>Adding a User</title>
</head>
<body class="container">
    <center>
        <h1>Editing a new user</h1>
        <a href="/EmployeeDetails">Home</a>
        <hr>
        <form action="./editUser" method="post">
            <div class="form-group">
                <label>
                    <input type="text" class="form-control" placeholder="Enter an ID to edit" name="id" required>
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="text" class="form-control" placeholder="New Name" name="name" value="">
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="password" class="form-control" placeholder="New Password" name="password" value="">
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="text" class="form-control" placeholder="New Age" name="age" value="">
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="text" class="form-control" placeholder="New Phone" name="phone" value="">
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="text" class="form-control" placeholder="New Address" name="address" value="">
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="text" class="form-control" placeholder="New Salary" name="salary" value="">
                </label>
            </div>

            <div class="form-check form-check-inline">
                <label class="form-check-label">No Change
                    <input class="form-check-input" type="radio" name="role" value="" checked>
                </label>
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label">User
                    <input class="form-check-input" type="radio" name="role" value="u">
                </label>
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label">Admin
                    <input class="form-check-input" type="radio" name="role" value="a">
                </label>
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label">Doctor
                    <input class="form-check-input" type="radio" name="role" value="d">
                </label>
            </div>
            <hr>
            <br>
            <div class="form-group">
                <input class="btn btn-primary" type="submit">
            </div>
        </form>
    </center>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>