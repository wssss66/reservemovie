
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReservationReservationManager from "./components/listers/ReservationReservationCards"
import ReservationReservationDetail from "./components/listers/ReservationReservationDetail"

import ManagemovieManagemovieManager from "./components/listers/ManagemovieManagemovieCards"
import ManagemovieManagemovieDetail from "./components/listers/ManagemovieManagemovieDetail"

import PointPointManager from "./components/listers/PointPointCards"
import PointPointDetail from "./components/listers/PointPointDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reservations/reservations',
                name: 'ReservationReservationManager',
                component: ReservationReservationManager
            },
            {
                path: '/reservations/reservations/:id',
                name: 'ReservationReservationDetail',
                component: ReservationReservationDetail
            },

            {
                path: '/managemovies/managemovies',
                name: 'ManagemovieManagemovieManager',
                component: ManagemovieManagemovieManager
            },
            {
                path: '/managemovies/managemovies/:id',
                name: 'ManagemovieManagemovieDetail',
                component: ManagemovieManagemovieDetail
            },

            {
                path: '/points/points',
                name: 'PointPointManager',
                component: PointPointManager
            },
            {
                path: '/points/points/:id',
                name: 'PointPointDetail',
                component: PointPointDetail
            },




    ]
})
