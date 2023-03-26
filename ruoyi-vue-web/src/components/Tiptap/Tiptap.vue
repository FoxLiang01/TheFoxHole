<template>
    <div v-if="editor" class="content">
      <div class="bar">
        <el-tooltip content="Bold" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleBold().run()" :disabled="!editor.can().chain().focus().toggleBold().run()" :class="{ 'is-active': editor.isActive('bold') }">
            <i class="ri-bold"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Italic" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleItalic().run()" :disabled="!editor.can().chain().focus().toggleItalic().run()" :class="{ 'is-active': editor.isActive('italic') }">
            <i class="ri-italic"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Strike" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleStrike().run()" :disabled="!editor.can().chain().focus().toggleStrike().run()" :class="{ 'is-active': editor.isActive('strike') }">
            <i class="ri-strikethrough"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Code" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleCode().run()" :disabled="!editor.can().chain().focus().toggleCode().run()" :class="{ 'is-active': editor.isActive('code') }">
            <i class="ri-code-view"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Clear marks" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().unsetAllMarks().run()">
            <i class="ri-brush-3-line"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Heading 1" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleHeading({ level: 1 }).run()" :class="{ 'is-active': editor.isActive('heading', { level: 1 }) }">
            <i class="ri-h-1"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Heading 2" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleHeading({ level: 2 }).run()" :class="{ 'is-active': editor.isActive('heading', { level: 2 }) }">
            <i class="ri-h-2"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Heading 3" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleHeading({ level: 3 }).run()" :class="{ 'is-active': editor.isActive('heading', { level: 3 }) }">
            <i class="ri-h-3"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Bullet list" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleBulletList().run()" :class="{ 'is-active': editor.isActive('bulletList') }">
            <i class="ri-list-unordered"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Ordered list" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleOrderedList().run()" :class="{ 'is-active': editor.isActive('orderedList') }">
            <i class="ri-list-ordered"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Code block" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleCodeBlock().run()" :class="{ 'is-active': editor.isActive('codeBlock') }">
            <i class="ri-code-box-line"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Blockquote" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().toggleBlockquote().run()" :class="{ 'is-active': editor.isActive('blockquote') }">
            <i class="ri-double-quotes-l"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Horizontal rule" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().setHorizontalRule().run()">
            <i class="ri-separator"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Hard break" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().setHardBreak().run()">
            <i class="ri-text-wrap"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Undo" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().undo().run()" :disabled="!editor.can().chain().focus().undo().run()">
            <i class="ri-arrow-go-back-line"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Redo" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().redo().run()" :disabled="!editor.can().chain().focus().redo().run()">
            <i class="ri-arrow-go-forward-line"></i>
          </div>
        </el-tooltip>
      </div>

      <editor-content :editor="editor"  class="input"/>

    </div>

  </template>

  <script>
  import { Editor, EditorContent } from '@tiptap/vue-2'
  import StarterKit from '@tiptap/starter-kit'

  export default {
    components: {
      EditorContent,
    },

    data() {
      return {
        editor: null,
      }
    },

    mounted() {
      this.editor = new Editor({
        content: '<p>I’m running Tiptap with Vue.js. 🎉代码块和引用的样式写不进去</p>',
        extensions: [
          StarterKit,

        ],
      })
    },

    beforeDestroy() {
      this.editor.destroy()
    },
  }
  </script>

<style lang="scss" scoped>
  .content{
    display: flex;
    justify-content: center;
    flex-direction: column;
    border: 3px #0D0D0D solid;
    border-radius: 20px;

    .bar{
      display: flex;
      border-bottom: 3px #0D0D0D solid;
      padding: 10px;
      flex-wrap: wrap;

      :hover{
        background-color: #0D0D0D;
        color: #FFF;
        transition: 0.2s;
      }

      div{
        padding: 5px;
        background-color: transparent;
        color: #0D0D0D;
        font-size: 1em;
        border-radius: 5px;
        margin-right: 3px;
      }
    }

    .input{
      margin: 0 10px;
      min-height: 300px;


    }
  }

  .ProseMirror {
    > * + * {
      margin-top: 0.75em;
    }

    ul,
    ol {
      padding: 0 1rem;
    }

    h1,
    h2,
    h3,
    h4,
    h5,
    h6 {
      line-height: 1.1;
    }

    code {
      background-color: rgba(#616161, 0.1);
      color: #616161;
    }

    pre {
      background: #0D0D0D;
      color: #FFF;
      font-family: 'JetBrainsMono', monospace;
      padding: 0.75rem 1rem;
      border-radius: 0.5rem;

      code {
        color: inherit;
        padding: 0;
        background: none;
        font-size: 0.8rem;
      }
    }

    img {
      max-width: 100%;
      height: auto;
    }

    blockquote {
      padding-left: 1rem;
      border-left: 2px solid rgba(#0D0D0D, 0.1);
    }

    hr {
      border: none;
      border-top: 2px solid rgba(#0D0D0D, 0.1);
      margin: 2rem 0;
    }
  }

</style>
