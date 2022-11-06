# base image
FROM node:14.21.0-slim

# set working directory
WORKDIR /app

# install and cache app dependencies
COPY . ./
# RUN npm install -g @vue/cli
RUN npm install

# RUN npm run build

# start app
CMD ["npm", "run", "serve"]