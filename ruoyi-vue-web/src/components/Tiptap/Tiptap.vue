<template>
    <div v-if="editor" :class="{content:editable}">
      <div class="bar" v-if="editable">
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
        <el-tooltip content="Set Link" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="setLink" :class="{ 'is-active': editor.isActive('link') }">
            <i class="ri-link"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Unset Link" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().unsetLink().run()" :disabled="!editor.isActive('link')">
            <i class="ri-link-unlink"></i>
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
        <span class="line"></span>
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
        <el-tooltip content="Left" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().setTextAlign('left').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'left' }) }">
            <i class="ri-align-left"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Center" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().setTextAlign('center').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'center' }) }">
            <i class="ri-align-center"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Right" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().setTextAlign('right').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'right' }) }">
            <i class="ri-align-right"></i>
          </div>
        </el-tooltip>
        <el-tooltip content="Justify" placement="top" effect="light" class="el-tooltip" :open-delay="1000">
          <div @click="editor.chain().focus().setTextAlign('justify').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'justify' }) }">
            <i class="ri-align-justify"></i>
          </div>
        </el-tooltip>
        <span class="line"></span>
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

      <editor-content :editor="editor" class="input"/>
    </div>

  </template>

  <script>
  import { Editor, EditorContent } from '@tiptap/vue-2'
  import StarterKit from '@tiptap/starter-kit'
  import Typography from '@tiptap/extension-typography'
  import Link from '@tiptap/extension-link'
  import TextAlign from '@tiptap/extension-text-align'

  export default {
    components: {
      EditorContent,
    },

    props:{
      value:{
        type:String,
        default:''
      },
      editable:{
        type:Boolean,
        default:false
      }
    },

    data() {
      return {
        editor: null,
      }
    },

    watch: {
      value(value) {
        const isSame = this.editor.getHTML() === value;
        if (isSame) {
          return
        }else{
          this.editor.commands.setContent(value, false)
        }

      },
    },

    mounted() {
      this.editor = new Editor({
        editable: this.editable,
        content: this.value,
        extensions: [
          StarterKit,
          Typography,
          Link.configure({
            openOnClick: false,
          }),
          TextAlign.configure({
            types: ['heading', 'paragraph'],
          }),
        ],
        onUpdate: () => {
          // HTML
          this.$emit('input', this.editor.getHTML());
        }
      })
    },

    methods: {
      setLink() {
        const previousUrl = this.editor.getAttributes('link').href
        const url = window.prompt('URL', previousUrl)
        // cancelled
        if (url === null) {
          return
        }
        // empty
        if (url === '') {
          this.editor
            .chain()
            .focus()
            .extendMarkRange('link')
            .unsetLink()
            .run()

          return
        }
        // update link
        this.editor
          .chain()
          .focus()
          .extendMarkRange('link')
          .setLink({ href: url })
          .run()
      },
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

    .line{
      box-sizing: border-box;
      display: inline;
      width: 0.5em;
      height: 1.5em;
      border-left: 2px solid rgba(#0D0D0D, 0.1);

      &:hover{
        background-color: transparent;
      }
    }

    .input{
      margin: 0 10px;
      min-height: 300px;
    }
  }


</style>

<style lang="scss">
  .ProseMirror {
    > * + * {
      margin-top: 0.75em;
    }

    a{
      color: #68CEF8;
      text-decoration: underline;
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
