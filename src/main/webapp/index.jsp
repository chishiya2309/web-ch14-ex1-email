<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Murach's Java Servlets and JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">

    <div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
        
        <h1 class="text-2xl font-bold text-gray-800 mb-2 text-center">Join our email list</h1>
        
        <p class="text-gray-600 text-center mb-6 text-sm">
            To join our email list, enter your name and email address below.
        </p>

        <div class="mb-4 text-center">
            <i class="text-red-500 font-medium">${message}</i>
        </div>

        <form action="emailList" method="post" class="space-y-4">
            <input type="hidden" name="action" value="add">        

            <div>
                <label class="block text-gray-700 text-sm font-bold mb-2" for="email">
                    Email:
                </label>
                <input type="email" name="email" id="email" value="${user.email}" required
                    class="shadow-sm border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent">
            </div>

            <div>
                <label class="block text-gray-700 text-sm font-bold mb-2" for="firstName">
                    First Name:
                </label>
                <input type="text" name="firstName" id="firstName" value="${user.firstName}" required
                    class="shadow-sm border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent">
            </div>

            <div>
                <label class="block text-gray-700 text-sm font-bold mb-2" for="lastName">
                    Last Name:
                </label>
                <input type="text" name="lastName" id="lastName" value="${user.lastName}" required
                    class="shadow-sm border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent">
            </div>        

            <div class="pt-2">
                <input type="submit" value="Join Now" 
                    class="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline cursor-pointer transition duration-150 ease-in-out">
            </div>
        </form>
    </div>

</body>
</html>