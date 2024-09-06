# Stage 1: Build the frontend
FROM node:16 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the source code
COPY . .

# Build the frontend for production
RUN npm run build

# Stage 2: Serve frontend with Nginx
FROM nginx:alpine

# Copy custom Nginx configuration
COPY nginx.conf /etc/nginx/nginx.conf
ENV BACKEND_HOST backend
ENV BACKEND_PORT 8000

# Remove the default Nginx static assets
RUN rm -rf /usr/share/nginx/html/*

# Copy the built frontend files from the build stage
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
