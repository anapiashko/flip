# base image
FROM node:14.17.6

# set working directory
WORKDIR /app

# install and cache app dependencies
COPY package.json /app/
RUN npm install
RUN npm install -g @vue/cli

COPY . /app
RUN npm run build

# start app
CMD ["npm", "run", "serve"]