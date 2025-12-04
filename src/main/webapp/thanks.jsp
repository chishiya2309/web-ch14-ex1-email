<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Murach's Java Servlets and JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 flex items-center justify-center min-h-screen">

    <div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md border-t-4 border-blue-600">
        
        <h1 class="text-2xl font-bold text-gray-800 mb-2 text-center">Thank you!</h1>
        <p class="text-gray-600 text-center mb-8">
            Thanks for joining our email list. Here is the information you entered:
        </p>

        <div class="space-y-4 mb-8">
            <div class="border-b border-gray-200 pb-2">
                <label class="block text-xs font-bold text-gray-500 uppercase tracking-wide">Email</label>
                <span class="text-lg text-gray-900 block">${user.email}</span>
            </div>

            <div class="border-b border-gray-200 pb-2">
                <label class="block text-xs font-bold text-gray-500 uppercase tracking-wide">First Name</label>
                <span class="text-lg text-gray-900 block">${user.firstName}</span>
            </div>

            <div class="border-b border-gray-200 pb-2">
                <label class="block text-xs font-bold text-gray-500 uppercase tracking-wide">Last Name</label>
                <span class="text-lg text-gray-900 block">${user.lastName}</span>
            </div>
        </div>

        <p class="text-gray-500 text-sm text-center mb-4">
            To enter another email address, click the button below.
        </p>

        <form action="" method="post">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return" 
                   class="w-full bg-gray-600 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline cursor-pointer transition duration-150 ease-in-out">
        </form>

        <div class="mt-4 text-center">
            <i class="text-red-500 text-sm font-medium">${errorMessage}</i>
        </div>
        
    </div>
</body>
</html>