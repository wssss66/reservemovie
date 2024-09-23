<template>

    <v-card outlined>
        <v-card-title>
            View # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Userid" v-model="item.userid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Movieid" v-model="item.movieid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Point" v-model="item.point" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ViewViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/views/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

