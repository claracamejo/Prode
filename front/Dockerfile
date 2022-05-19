FROM node:16-alpine

RUN mkdir /front
WORKDIR /front
COPY . /front/

RUN npm install
#RUN npm run build

EXPOSE 3000

CMD [ "npm", "start"]