// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/proto/build/VipProto.proto

package com.dh.game.vo.build;

public final class VipProto {
  private VipProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface DayVipGiftInfoRespOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // required int32 rechargeHis = 1;
    boolean hasRechargeHis();
    int getRechargeHis();
    
    // required int32 status = 2;
    boolean hasStatus();
    int getStatus();
  }
  public static final class DayVipGiftInfoResp extends
      com.google.protobuf.GeneratedMessage
      implements DayVipGiftInfoRespOrBuilder {
    // Use DayVipGiftInfoResp.newBuilder() to construct.
    private DayVipGiftInfoResp(Builder builder) {
      super(builder);
    }
    private DayVipGiftInfoResp(boolean noInit) {}
    
    private static final DayVipGiftInfoResp defaultInstance;
    public static DayVipGiftInfoResp getDefaultInstance() {
      return defaultInstance;
    }
    
    public DayVipGiftInfoResp getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dh.game.vo.build.VipProto.internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dh.game.vo.build.VipProto.internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_fieldAccessorTable;
    }
    
    private int bitField0_;
    // required int32 rechargeHis = 1;
    public static final int RECHARGEHIS_FIELD_NUMBER = 1;
    private int rechargeHis_;
    public boolean hasRechargeHis() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public int getRechargeHis() {
      return rechargeHis_;
    }
    
    // required int32 status = 2;
    public static final int STATUS_FIELD_NUMBER = 2;
    private int status_;
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public int getStatus() {
      return status_;
    }
    
    private void initFields() {
      rechargeHis_ = 0;
      status_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasRechargeHis()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasStatus()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, rechargeHis_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, status_);
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, rechargeHis_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, status_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.dh.game.vo.build.VipProto.DayVipGiftInfoResp parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dh.game.vo.build.VipProto.DayVipGiftInfoResp prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.dh.game.vo.build.VipProto.DayVipGiftInfoRespOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.dh.game.vo.build.VipProto.internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.dh.game.vo.build.VipProto.internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_fieldAccessorTable;
      }
      
      // Construct using com.dh.game.vo.build.VipProto.DayVipGiftInfoResp.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        rechargeHis_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        status_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dh.game.vo.build.VipProto.DayVipGiftInfoResp.getDescriptor();
      }
      
      public com.dh.game.vo.build.VipProto.DayVipGiftInfoResp getDefaultInstanceForType() {
        return com.dh.game.vo.build.VipProto.DayVipGiftInfoResp.getDefaultInstance();
      }
      
      public com.dh.game.vo.build.VipProto.DayVipGiftInfoResp build() {
        com.dh.game.vo.build.VipProto.DayVipGiftInfoResp result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.dh.game.vo.build.VipProto.DayVipGiftInfoResp buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.dh.game.vo.build.VipProto.DayVipGiftInfoResp result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.dh.game.vo.build.VipProto.DayVipGiftInfoResp buildPartial() {
        com.dh.game.vo.build.VipProto.DayVipGiftInfoResp result = new com.dh.game.vo.build.VipProto.DayVipGiftInfoResp(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.rechargeHis_ = rechargeHis_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.status_ = status_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dh.game.vo.build.VipProto.DayVipGiftInfoResp) {
          return mergeFrom((com.dh.game.vo.build.VipProto.DayVipGiftInfoResp)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.dh.game.vo.build.VipProto.DayVipGiftInfoResp other) {
        if (other == com.dh.game.vo.build.VipProto.DayVipGiftInfoResp.getDefaultInstance()) return this;
        if (other.hasRechargeHis()) {
          setRechargeHis(other.getRechargeHis());
        }
        if (other.hasStatus()) {
          setStatus(other.getStatus());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasRechargeHis()) {
          
          return false;
        }
        if (!hasStatus()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              rechargeHis_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              status_ = input.readInt32();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required int32 rechargeHis = 1;
      private int rechargeHis_ ;
      public boolean hasRechargeHis() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public int getRechargeHis() {
        return rechargeHis_;
      }
      public Builder setRechargeHis(int value) {
        bitField0_ |= 0x00000001;
        rechargeHis_ = value;
        onChanged();
        return this;
      }
      public Builder clearRechargeHis() {
        bitField0_ = (bitField0_ & ~0x00000001);
        rechargeHis_ = 0;
        onChanged();
        return this;
      }
      
      // required int32 status = 2;
      private int status_ ;
      public boolean hasStatus() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public int getStatus() {
        return status_;
      }
      public Builder setStatus(int value) {
        bitField0_ |= 0x00000002;
        status_ = value;
        onChanged();
        return this;
      }
      public Builder clearStatus() {
        bitField0_ = (bitField0_ & ~0x00000002);
        status_ = 0;
        onChanged();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.dh.game.vo.build.DayVipGiftInfoResp)
    }
    
    static {
      defaultInstance = new DayVipGiftInfoResp(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.dh.game.vo.build.DayVipGiftInfoResp)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036com/proto/build/VipProto.proto\022\024com.dh" +
      ".game.vo.build\"9\n\022DayVipGiftInfoResp\022\023\n\013" +
      "rechargeHis\030\001 \002(\005\022\016\n\006status\030\002 \002(\005"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_dh_game_vo_build_DayVipGiftInfoResp_descriptor,
              new java.lang.String[] { "RechargeHis", "Status", },
              com.dh.game.vo.build.VipProto.DayVipGiftInfoResp.class,
              com.dh.game.vo.build.VipProto.DayVipGiftInfoResp.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}