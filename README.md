# spring-boot-e-commerce
E-commerce toy project

### ecommerce (project name)
- Project
  - Project: Gradle Project
  - Language: Java
  - Spring Boot: 2.7.0

- Project Metadata
  - Group: com
  - Artifact: ecommerce
  - Name: ecommerce
  - Package name: com.ecommerce
  - Packaging: Jar
  - Java: 11

- Dependencies
  - Spring Web, Thymeleaf, Lombok, H2

### CSS
#### tailwind CSS
> Installation Guide  
> https://tailwindcss.com/docs/installation

1. Install Tailwind CSS  
Install `tailwindcss` via npm, and create your `tailwind.config.js` file.
   ```bash
   > npm install -D tailwindcss
   > npx tailwindcss init
   ```
1. Configure your template paths  
Add the paths to all of your template files in your `tailwind.config.js` file.
   ```js
   // tailwind.config.js
   module.exports = {
     content: ["./src/**/*.{html,js}"],
     theme: {
       extend: {},
     },
     plugins: [],
   }
   ```
1. Add the Tailwind directives to your CSS  
Add the `@tailwind` directives for each of Tailwind’s layers to your main CSS file.  
   ```css
   /* src/input.css */
   @tailwind base;
   @tailwind components;
   @tailwind utilities;
   ```
1. Start the Tailwind CLI build process  
Run the CLI tool to scan your template files for classes and build your CSS.
   ```bash
   > cd ./ecommerce/src/main/resources/static/tailwindcss
   > npx tailwindcss -i ./src/input.css -o ./dist/output.css --watch
   ```
1. Start using Tailwind in your HTML  
Add your compiled CSS file to the `<head>` and start using Tailwind’s utility classes to style your content.  
   ```html
   <!-- src/index.html -->
   <!doctype html>
   <html>
   <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="/dist/output.css" rel="stylesheet">
   </head>
   <body>
     <h1 class="text-3xl font-bold underline">
       Hello world!
     </h1>
   </body>
   </html>
   ```
#### tailwindcss-forms plugin
> Installation Guide  
> https://github.com/tailwindlabs/tailwindcss-forms
1. Install the plugin from npm  
   ```bash
   > npm install -D @tailwindcss/forms
   ```
1. Then add the plugin to your `tailwind.config.js` file  
   ```js
   // tailwind.config.js
   module.exports = {
     theme: {
       // ...
     },
     plugins: [
       require('@tailwindcss/forms'),
       // ...
     ],
   }
   ```
#### Flowbite - Tailwind CSS component library
> https://flowbite.com/docs/getting-started/introduction/