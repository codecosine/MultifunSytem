<template>
  <div role="dialog" class="modal">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <slot name="modal-header">
          <div class="modal-header">
            <button type="button" class="close" @click="close"><span>&times;</span></button>
            <h4 class="modal-title">
              在线查看
            </h4>
          </div>
        </slot>
        <slot name="modal-body">
          <div class="modal-body modal-scroll">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>#objectId</th>
                  <th>fraud</th>
                  <th>Unfraud</th>
                  <th>UnCertaintly</th>
                </tr>
              </thead>
              <tbody>
              <tr v-for="(item, index) in tables">
                <td v-for="text in item">{{ text }}</td>
              </tr>
              </tbody>

            </table>
          </div>
        </slot>
        <slot name="modal-footer">
          <div class="modal-footer">
            <a role="button" class="btn btn-primary" v-bind:href="'/download?resultFile='+resultFile">下载xls文件查看</a>
            <button type="button" class="btn btn-default" @click="close">关闭窗口</button>
          </div>
        </slot>
      </div>
    </div>
  </div>
</template>
<script>

export default {
  props: {
    title: {
      type: String,
      default: '',
    },
    resultFile: {
      type: String,
      default: '',
    },
    tables: {
      type: Array,
      default: [],
    },
    show: {
      required: true,
      type: Boolean,
    },
    close: {
      type: Function,
      default() {},
    },
  },
  watch: {
    show(val) {
      const el = this.$el;
      if (val) {
        el.style.display = 'block';
      } else {
        el.style.display = 'none';
      }
    },
  },

};
</script>
<style>
.modal-scroll {
  overflow-y: auto;
  max-height: 600px;
}
.modal {
  transition: all 0.3s ease;
}
.modal.in {
  background-color: rgba(0,0,0,0.5);
}
.modal.zoom .modal-dialog {
  -webkit-transform: scale(0.1);
  -moz-transform: scale(0.1);
  -ms-transform: scale(0.1);
  transform: scale(0.1);
  top: 300px;
  opacity: 0;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  transition: all 0.3s;
}
.modal.zoom.in .modal-dialog {
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  transform: scale(1);
  -webkit-transform: translate3d(0, -300px, 0);
  transform: translate3d(0, -300px, 0);
  opacity: 1;
}
</style>
